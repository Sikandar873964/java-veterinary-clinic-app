package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity(name = "hospital_bookings")
public class HospitalBooking {
    @Id
    @GeneratedValue
    @Column(name = "hospital_booking_id")
    private Long hospitalBookingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_id",
            referencedColumnName = "hospital_id")
    private Hospital hospital;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",
            referencedColumnName = "customer_id")
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double price;

    @CreatedDate
    private LocalDateTime createdTime;
    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;

    private String status;

    public Long getHospitalBookingId() {
        return hospitalBookingId;
    }

    public void setHospitalBookingId(Long hospitalBookingId) {
        this.hospitalBookingId = hospitalBookingId;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}