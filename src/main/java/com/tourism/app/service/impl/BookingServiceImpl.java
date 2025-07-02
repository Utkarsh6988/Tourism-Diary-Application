package com.tourism.app.service.impl;

import com.tourism.app.model.Booking;
import com.tourism.app.model.TourPackage;
import com.tourism.app.model.User;
import com.tourism.app.repository.BookingRepository;
import com.tourism.app.service.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
//        initializeSampleData();
    }

//    private void initializeSampleData() {
//        if (bookingRepository.count() == 0) {
//            // Create sample data only if database is empty
//            bookingRepository.saveAll(List.of(
//                new Booking("Goa Beach Trip", LocalDate.now(), LocalDate.now().plusDays(5), "Confirmed", "user1"),
//                new Booking("Himalaya Trek", LocalDate.now(), LocalDate.now().plusDays(10), "Pending", "user1"),
//                new Booking("Maldives Paradise", LocalDate.now(), LocalDate.now().plusDays(22), "Available", "user2"),
//                new Booking("Bali Retreat", LocalDate.now(), LocalDate.now().plusDays(37), "Available", "user3"),
//                new Booking("Swiss Alps Adventure", LocalDate.now(), LocalDate.now().plusMonths(2).plusDays(7), "Available", "admin"),
//                new Booking("Japanese Cultural Tour", LocalDate.now(), LocalDate.now().plusMonths(3).plusDays(10), "Available", "user1"),
//                new Booking("African Safari", LocalDate.now(), LocalDate.now().plusMonths(4).plusDays(14), "Available", "user2")
//            ));
//        }
//    }

    @Override
    public List<Booking> getBookingsForUser(String username) {
        return bookingRepository.findByUsername(username);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }
    
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }



}