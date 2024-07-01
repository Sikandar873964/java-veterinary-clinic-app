package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * The type Hospital booking.
 */
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

    /**
     * Gets hospital booking id.
     *
     * @return the hospital booking id
     */
    public Long getHospitalBookingId() {
        return hospitalBookingId;
    }

    /**
     * Sets hospital booking id.
     *
     * @param hospitalBookingId the hospital booking id
     */
    public void setHospitalBookingId(Long hospitalBookingId) {
        this.hospitalBookingId = hospitalBookingId;
    }

    /**
     * Gets hospital.
     *
     * @return the hospital
     */
    public Hospital getHospital() {
        return hospital;
    }

    /**
     * Sets hospital.
     *
     * @param hospital the hospital
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets created time.
     *
     * @return the created time
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets created time.
     *
     * @param createdTime the created time
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Gets last updated time.
     *
     * @return the last updated time
     */
    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * Sets last updated time.
     *
     * @param lastUpdatedTime the last updated time
     */
    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
