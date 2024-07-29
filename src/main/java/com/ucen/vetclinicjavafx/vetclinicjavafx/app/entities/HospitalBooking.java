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
    private String holderFirstName;
    private String holderLastName;
    private String holderAddress;

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

    /**
     * Gets holder first name.
     *
     * @return the holder first name
     */
    public String getHolderFirstName() {
        return holderFirstName;
    }

    /**
     * Sets holder first name.
     *
     * @param holderFirstName the holder first name
     */
    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    /**
     * Gets holder last name.
     *
     * @return the holder last name
     */
    public String getHolderLastName() {
        return holderLastName;
    }

    /**
     * Sets holder last name.
     *
     * @param holderLastName the holder last name
     */
    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
    }

    /**
     * Gets holder address.
     *
     * @return the holder address
     */
    public String getHolderAddress() {
        return holderAddress;
    }

    /**
     * Sets holder address.
     *
     * @param holderAddress the holder address
     */
    public void setHolderAddress(String holderAddress) {
        this.holderAddress = holderAddress;
    }

    /**
     * The type Hospital booking builder.
     */
    public static final class HospitalBookingBuilder {
        private Long hospitalBookingId;
        private Hospital hospital;
        private Customer customer;
        private String holderFirstName;
        private String holderLastName;
        private String holderAddress;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private Double price;
        private LocalDateTime createdTime;
        private LocalDateTime lastUpdatedTime;
        private String status;

        private HospitalBookingBuilder() {
        }

        /**
         * A hospital booking hospital booking builder.
         *
         * @return the hospital booking builder
         */
        public static HospitalBookingBuilder aHospitalBooking() {
            return new HospitalBookingBuilder();
        }

        /**
         * With hospital booking id hospital booking builder.
         *
         * @param hospitalBookingId the hospital booking id
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withHospitalBookingId(Long hospitalBookingId) {
            this.hospitalBookingId = hospitalBookingId;
            return this;
        }

        /**
         * With hospital hospital booking builder.
         *
         * @param hospital the hospital
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withHospital(Hospital hospital) {
            this.hospital = hospital;
            return this;
        }

        /**
         * With customer hospital booking builder.
         *
         * @param customer the customer
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        /**
         * With holder first name hospital booking builder.
         *
         * @param holderFirstName the holder first name
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withHolderFirstName(String holderFirstName) {
            this.holderFirstName = holderFirstName;
            return this;
        }

        /**
         * With holder last name hospital booking builder.
         *
         * @param holderLastName the holder last name
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withHolderLastName(String holderLastName) {
            this.holderLastName = holderLastName;
            return this;
        }

        /**
         * With holder address hospital booking builder.
         *
         * @param holderAddress the holder address
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withHolderAddress(String holderAddress) {
            this.holderAddress = holderAddress;
            return this;
        }

        /**
         * With start time hospital booking builder.
         *
         * @param startTime the start time
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        /**
         * With end time hospital booking builder.
         *
         * @param endTime the end time
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        /**
         * With price hospital booking builder.
         *
         * @param price the price
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        /**
         * With created time hospital booking builder.
         *
         * @param createdTime the created time
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withCreatedTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        /**
         * With last updated time hospital booking builder.
         *
         * @param lastUpdatedTime the last updated time
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withLastUpdatedTime(LocalDateTime lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
            return this;
        }

        /**
         * With status hospital booking builder.
         *
         * @param status the status
         * @return the hospital booking builder
         */
        public HospitalBookingBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        /**
         * Build hospital booking.
         *
         * @return the hospital booking
         */
        public HospitalBooking build() {
            HospitalBooking hospitalBooking = new HospitalBooking();
            hospitalBooking.setHospitalBookingId(hospitalBookingId);
            hospitalBooking.setHospital(hospital);
            hospitalBooking.setCustomer(customer);
            hospitalBooking.setHolderFirstName(holderFirstName);
            hospitalBooking.setHolderLastName(holderLastName);
            hospitalBooking.setHolderAddress(holderAddress);
            hospitalBooking.setStartTime(startTime);
            hospitalBooking.setEndTime(endTime);
            hospitalBooking.setPrice(price);
            hospitalBooking.setCreatedTime(createdTime);
            hospitalBooking.setLastUpdatedTime(lastUpdatedTime);
            hospitalBooking.setStatus(status);
            return hospitalBooking;
        }
    }
}
