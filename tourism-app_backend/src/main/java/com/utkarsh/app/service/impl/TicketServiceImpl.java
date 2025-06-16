package com.utkarsh.app.service.impl;

import com.utkarsh.app.exception.ResourceNotFoundException;
import com.utkarsh.app.model.Attraction;
import com.utkarsh.app.model.Ticket;
import com.utkarsh.app.model.User;
import com.utkarsh.app.repository.AttractionRepository;
import com.utkarsh.app.repository.TicketRepository;
import com.utkarsh.app.repository.UserRepository;
import com.utkarsh.app.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements ITicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final AttractionRepository attractionRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository,
                           UserRepository userRepository,
                           AttractionRepository attractionRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public Ticket bookTicket(Long userId, Long attractionId, LocalDate visitDate, int quantity) {
        // Input validation
        if (visitDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Visit date cannot be in the past");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        
        Attraction attraction = attractionRepository.findById(attractionId)
                .orElseThrow(() -> new ResourceNotFoundException("Attraction", "id", attractionId));
        
        if (!attraction.isCurrentlyAvailable()) {
            throw new IllegalStateException("Attraction is currently unavailable");
        }
        
        if (attraction.getAvailableTickets() < quantity) {
            throw new IllegalStateException("Only " + attraction.getAvailableTickets() + " tickets available");
        }
        
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setAttraction(attraction);
        ticket.setVisitDate(visitDate);
        ticket.setQuantity(quantity);
        ticket.setCanalName(attraction.getCanalName());
        
        attraction.decreaseAvailableTickets(quantity);
        attractionRepository.save(attraction);
        
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", ticketId));
    }

    @Override
    public List<Ticket> getUserTickets(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User", "id", userId);
        }
        return ticketRepository.findByUserId(userId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void cancelTicket(Long ticketId) {
        Ticket ticket = getTicketById(ticketId);
        Attraction attraction = ticket.getAttraction();
        
        attraction.increaseAvailableTickets(ticket.getQuantity());
        attractionRepository.save(attraction);
        
        ticketRepository.delete(ticket);
    }

    @Override
    public List<Ticket> getTicketsByAttraction(Long attractionId) {
        if (!attractionRepository.existsById(attractionId)) {
            throw new ResourceNotFoundException("Attraction", "id", attractionId);
        }
        return ticketRepository.findByAttractionId(attractionId);
    }
}