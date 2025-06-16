package com.utkarsh.app.repository;

import com.utkarsh.app.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    // Basic queries
    List<Attraction> findByNameContainingIgnoreCase(String name);
    List<Attraction> findByLocation(String location);
    List<Attraction> findByCanalName(String canalName);
    
    // Availability query
    List<Attraction> findByAvailableTicketsGreaterThan(Integer minTickets);
    
    // Price range query
    List<Attraction> findByTicketPriceBetween(Double minPrice, Double maxPrice);
    
    // Search query
    List<Attraction> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
    
    // Custom queries
    @Query("SELECT a FROM Attraction a WHERE a.availableTickets > 0")
    List<Attraction> findAvailableAttractions();

    @Query("SELECT a FROM Attraction a WHERE a.availableTickets > 0 AND a.id NOT IN " +
           "(SELECT t.attraction.id FROM Ticket t WHERE t.visitDate = :date)")
    List<Attraction> findAvailableAttractionsByDate(@Param("date") LocalDate date);

    long countByLocation(String location);
}