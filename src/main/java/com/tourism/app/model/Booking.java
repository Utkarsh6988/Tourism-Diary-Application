//package com.tourism.app.model;
//
//import java.time.LocalDate;
//
//public class Booking {
//    private String packageName;
//    private LocalDate bookingDate;
//    private LocalDate travelDate;
//    private String status;
//
//    // Constructors, getters, setters
//    public Booking(String packageName, LocalDate bookingDate, LocalDate travelDate, String status) {
//        this.packageName = packageName;
//        this.bookingDate = bookingDate;
//        this.travelDate = travelDate;
//        this.status = status;
//    }
//
//	public String getPackageName() {
//		return packageName;
//	}
//
//	public void setPackageName(String packageName) {
//		this.packageName = packageName;
//	}
//
//	public LocalDate getBookingDate() {
//		return bookingDate;
//	}
//
//	public void setBookingDate(LocalDate bookingDate) {
//		this.bookingDate = bookingDate;
//	}
//
//	public LocalDate getTravelDate() {
//		return travelDate;
//	}
//
//	public void setTravelDate(LocalDate travelDate) {
//		this.travelDate = travelDate;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//    // Getters and setters here
//    
//}
package com.tourism.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String packageName;
    
    @Column(nullable = false)
    private LocalDate bookingDate;
    
    @Column(nullable = false)
    private LocalDate travelDate;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private String username; // To associate bookings with users

    // Constructors
    public Booking() {
    }

    public Booking(String packageName, LocalDate bookingDate, LocalDate travelDate, String status, String username) {
        this.packageName = packageName;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.status = status;
        this.username = username;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}