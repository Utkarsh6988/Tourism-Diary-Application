package com.tourism.app.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private TourPackage tourPackage;

    private String bookingDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TourPackage getTourPackage() {
		return tourPackage;
	}

	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

    // Getters and Setters
    
}