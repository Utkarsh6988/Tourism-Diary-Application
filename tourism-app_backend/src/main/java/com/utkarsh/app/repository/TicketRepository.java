package com.utkarsh.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utkarsh.app.model.Attraction;
import com.utkarsh.app.model.Ticket;
import com.utkarsh.app.model.User;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUser(User user);
    List<Ticket> findByUserAndVisitDate(User user, LocalDate visitDate);
    List<Ticket> findByStatus(String status);
 // Add this method to your TicketRepository interface
    List<Ticket> findByAttraction(Attraction attraction);
    
    /**
     * Finds all tickets for a specific user
     * @param userId The ID of the user
     * @return List of tickets belonging to the user
     */
    @Query("SELECT t FROM Ticket t WHERE t.user.id = :userId")
    List<Ticket> findByUserId(@Param("userId") Long userId);

    /**
     * Finds all tickets for a specific attraction
     * @param attractionId The ID of the attraction
     * @return List of tickets for the attraction
     */
    @Query("SELECT t FROM Ticket t WHERE t.attraction.id = :attractionId")
    List<Ticket> findByAttractionId(@Param("attractionId") Long attractionId);

    // Other methods...
    boolean existsByUserIdAndAttractionIdAndVisitDate(Long userId, Long attractionId, LocalDate visitDate);
}
