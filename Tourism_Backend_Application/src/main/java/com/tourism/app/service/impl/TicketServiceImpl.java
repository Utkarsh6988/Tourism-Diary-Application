package com.tourism.app.service.impl;

import com.tourism.app.model.Ticket;


import com.tourism.app.repository.TicketRepository;
import com.tourism.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired private TicketRepository ticketRepo;

    @Override
    public Ticket bookTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }
}
