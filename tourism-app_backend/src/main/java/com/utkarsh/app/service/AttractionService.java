package com.utkarsh.app.service;

import com.utkarsh.app.exception.ResourceNotFoundException;
import com.utkarsh.app.model.Attraction;
import com.utkarsh.app.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class AttractionService {

    private final AttractionRepository attractionRepository;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public Attraction createAttraction(Attraction attraction) {
        if (attraction.getAvailableTickets() == null) {
            attraction.setAvailableTickets(0);
        }
        return attractionRepository.save(attraction);
    }

    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    public Attraction getAttractionById(Long id) {
        return attractionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attraction", "id", id));
    }

    public Attraction updateAttraction(Long id, Attraction attractionDetails) {
        Attraction attraction = getAttractionById(id);
        
        attraction.setName(attractionDetails.getName());
        attraction.setDescription(attractionDetails.getDescription());
        attraction.setLocation(attractionDetails.getLocation());
        attraction.setCanalName(attractionDetails.getCanalName());
        attraction.setTicketPrice(attractionDetails.getTicketPrice());
        attraction.setAvailableTickets(attractionDetails.getAvailableTickets());
        attraction.setImageUrl(attractionDetails.getImageUrl());
        attraction.setOpeningTime(attractionDetails.getOpeningTime());
        attraction.setClosingTime(attractionDetails.getClosingTime());
        
        return attractionRepository.save(attraction);
    }

    public void deleteAttraction(Long id) {
        Attraction attraction = getAttractionById(id);
        attractionRepository.delete(attraction);
    }

    public List<Attraction> getAttractionsByCanal(String canalName) {
        return attractionRepository.findByCanalName(canalName);
    }

    public List<Attraction> getAvailableAttractions() {
        return attractionRepository.findByAvailableTicketsGreaterThan(0);
    }

    public List<Attraction> getAttractionsByPriceRange(Double minPrice, Double maxPrice) {
        return attractionRepository.findByTicketPriceBetween(minPrice, maxPrice);
    }

    public List<Attraction> searchAttractions(String query) {
        return attractionRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }

    public boolean isAttractionAvailable(Long attractionId) {
        Attraction attraction = getAttractionById(attractionId);
        LocalTime now = LocalTime.now();
        return attraction.getAvailableTickets() > 0 && 
               now.isAfter(attraction.getOpeningTime()) && 
               now.isBefore(attraction.getClosingTime());
    }

    @Transactional
    public void decreaseAvailableTickets(Long attractionId, int quantity) {
        Attraction attraction = getAttractionById(attractionId);
        attraction.decreaseAvailableTickets(quantity);
        attractionRepository.save(attraction);
    }

    @Transactional
    public void increaseAvailableTickets(Long attractionId, int quantity) {
        Attraction attraction = getAttractionById(attractionId);
        attraction.increaseAvailableTickets(quantity);
        attractionRepository.save(attraction);
    }
}