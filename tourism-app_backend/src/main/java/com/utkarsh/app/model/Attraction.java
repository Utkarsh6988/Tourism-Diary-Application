package com.utkarsh.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "attractions")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3-100 characters")
    @Column(nullable = false)
    private String name;
    
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @NotBlank(message = "Location is required")
    @Column(nullable = false)
    private String location;
    
    @Column(name = "canal_name")
    private String canalName;
    
    @NotNull(message = "Ticket price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(nullable = false, precision = 10, scale = 2)
    private Double ticketPrice;
    
    @Min(value = 0, message = "Available tickets cannot be negative")
    @Column(name = "available_tickets")
    private Integer availableTickets = 0;
    
    @URL(message = "Image URL must be valid")
    private String imageUrl;
    
    @Column(name = "opening_time")
    private LocalTime openingTime = LocalTime.of(9, 0);
    
    @Column(name = "closing_time")
    private LocalTime closingTime = LocalTime.of(18, 0);
    
    @Enumerated(EnumType.STRING)
    private AttractionStatus status = AttractionStatus.ACTIVE;
    
    @OneToMany(mappedBy = "attraction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    // Constructors
    public Attraction() {}

    public Attraction(String name, String location, Double ticketPrice) {
        this.name = name;
        this.location = location;
        this.ticketPrice = ticketPrice;
    }

    // Business Logic Methods
    public boolean isCurrentlyAvailable() {
        LocalTime now = LocalTime.now();
        return status == AttractionStatus.ACTIVE && 
               availableTickets > 0 && 
               now.isAfter(openingTime) && 
               now.isBefore(closingTime);
    }
    
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setAttraction(this);
    }
    
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setAttraction(null);
    }
    
    public void decreaseAvailableTickets(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (this.availableTickets < quantity) throw new IllegalStateException("Not enough tickets available");
        this.availableTickets -= quantity;
    }

    public void increaseAvailableTickets(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        this.availableTickets += quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getCanalName() { return canalName; }
    public void setCanalName(String canalName) { this.canalName = canalName; }
    public Double getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(Double ticketPrice) { this.ticketPrice = ticketPrice; }
    public Integer getAvailableTickets() { return availableTickets; }
    public void setAvailableTickets(Integer availableTickets) { this.availableTickets = availableTickets; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public LocalTime getOpeningTime() { return openingTime; }
    public void setOpeningTime(LocalTime openingTime) { this.openingTime = openingTime; }
    public LocalTime getClosingTime() { return closingTime; }
    public void setClosingTime(LocalTime closingTime) { this.closingTime = closingTime; }
    public AttractionStatus getStatus() { return status; }
    public void setStatus(AttractionStatus status) { this.status = status; }
    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
}

enum AttractionStatus {
    ACTIVE, MAINTENANCE, CLOSED, COMING_SOON
}