package com.tourism.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import com.tourism.app.model.Booking;
import com.tourism.app.model.TourPackage;
import com.tourism.app.model.User;
import com.tourism.app.service.BookingService;
import com.tourism.app.service.PackageService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    private final PackageService packageService;
    private final BookingService bookingService;

    @Autowired
    public DashboardController(PackageService packageService, BookingService bookingService) {
        this.packageService = packageService;
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public String showBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        
        // Add this line to enable Java 8 date formatting
        model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("dd MMM yyyy"));
        
        return "bookings";
    }
  @GetMapping("/packages")
  public String showPackages(Model model) {
      List<TourPackage> packages = packageService.getAllPackages();
      model.addAttribute("tourPackages", packages);
      return "packages";
  }

  @GetMapping("/profile")
  public String showProfile(Model model, HttpSession session) {
      User user = (User) session.getAttribute("user");

      // Optional: provide a fallback guest user
      if (user == null) {
          user = new User();
          user.setName("Utkarsh Arora");
          user.setEmail("utkarsh@example.com");
          // You can leave phone/address null or set dummy values
      }

      model.addAttribute("user", user);
      return "profile";
  }
  @PostMapping("/bookings/book")
  public String bookPackage(@RequestParam("packageId") Long packageId, 
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {

      String username = "guest@tourism.com";
      User user = (User) session.getAttribute("user");
      if (user != null) {
          username = user.getEmail();
      }

      TourPackage tourPackage = packageService.getPackageById(packageId);
      if (tourPackage != null) {
          List<Booking> existingBookings = bookingService.getBookingsForUser(username);
          boolean alreadyBooked = existingBookings.stream()
                  .anyMatch(b -> b.getPackageName().equalsIgnoreCase(tourPackage.getName()));

          if (alreadyBooked) {
              redirectAttributes.addFlashAttribute("popupMessage", 
                  "You have already booked the package: " + tourPackage.getName());
              redirectAttributes.addFlashAttribute("popupType", "error");
              return "redirect:/bookings"; // Redirect to bookings page
          }

          Booking booking = new Booking();
          booking.setPackageName(tourPackage.getName());
          booking.setBookingDate(LocalDate.now());
          booking.setTravelDate(LocalDate.now().plusDays(10));
          booking.setStatus("Confirmed");
          booking.setUsername(username);

          bookingService.saveBooking(booking);
          redirectAttributes.addFlashAttribute("popupMessage", 
              "Package booked successfully: " + tourPackage.getName());
          redirectAttributes.addFlashAttribute("popupType", "success");
      }

      return "redirect:/bookings"; // Always redirect to bookings page
  }
  
  @PostMapping("/bookings/{id}/cancel")
  public ResponseEntity<Map<String, String>> cancelBooking(@PathVariable Long id, HttpSession session) {
      User user = (User) session.getAttribute("user");
      
      // For testing if session is null
      if (user == null) {
          user = new User();
          user.setEmail("user1");
          session.setAttribute("user", user);
      }
      

      Booking booking = bookingService.getBookingById(id);
      if (booking == null) {
          return ResponseEntity.status(404)
              .body(Collections.singletonMap("message", "Booking not found"));
      }

      if (!booking.getUsername().equals(user.getEmail())) {
          return ResponseEntity.status(403)
              .body(Collections.singletonMap("message", "Forbidden: Not your booking"));
      }

      if ("Cancelled".equalsIgnoreCase(booking.getStatus())) {
          return ResponseEntity.badRequest()
              .body(Collections.singletonMap("message", "Booking already cancelled"));
      }

      booking.setStatus("Cancelled");
      bookingService.saveBooking(booking);

      return ResponseEntity.ok()
          .body(Collections.singletonMap("message", "Booking cancelled successfully"));
  }
  
//Optional: for Swagger manual session simulation
  @PostMapping("/test/login")
  public ResponseEntity<String> simulateLogin(HttpSession session) {
      User user = new User();
      user.setEmail("user1");
      user.setName("Swagger Test User");
      session.setAttribute("user", user);
      return ResponseEntity.ok("Test user added to session");
  }

}

