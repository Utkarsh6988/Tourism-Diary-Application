package com.utkarsh.app.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TicketBookingDto {
    @NotNull(message = "User ID is required")
    private Long userId;
    
    @NotNull(message = "Attraction ID is required") 
    private Long attractionId;
    
    @NotBlank(message = "Canal name is required")
    private String canalName;
    
    @NotNull(message = "Visit date is required") 
    @Future(message = "Visit date must be in the future")
    private LocalDate visitDate;
    
    @NotNull(message = "Quantity is required") 
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    
    private String deviceInfo;

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Long attractionId) {
        this.attractionId = attractionId;
    }

    public String getCanalName() {
        return canalName;
    }

    public void setCanalName(String canalName) {
        this.canalName = canalName;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}