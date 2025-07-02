package com.tourism.app.service;

import com.tourism.app.model.Booking;
import com.tourism.app.model.User;

import java.util.List;

public interface BookingService {
    List<Booking> getBookingsForUser(String username);
    List<Booking> getAllBookings(); // Add this new method
    
    void saveBooking(Booking booking);
    
    public Booking getBookingById(Long id) ;
        
	
}
