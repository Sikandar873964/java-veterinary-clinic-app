package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.*;

/**
 * The type Hospital booking item.
 */
@Entity(name = "hospital_booking_items")
public class HospitalBookingItem {
    @Id
    @GeneratedValue
    @Column(name = "hospital_booking_item_id")
    private Long hospitalBookingId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_booking_id",
            referencedColumnName = "hospital_booking_id")
    private HospitalBooking hospitalBooking;
    @Column(name = "reason")
    private String reason;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id",
            referencedColumnName = "animal_id")
    private Animal animal;
    private Boolean needsAdditionalAssistant;
    private Boolean additionalSurCharge;
    private Boolean longDistance;
    private Double price;

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
     * Gets hospital booking.
     *
     * @return the hospital booking
     */
    public HospitalBooking getHospitalBooking() {
        return hospitalBooking;
    }

    /**
     * Sets hospital booking.
     *
     * @param hospitalBooking the hospital booking
     */
    public void setHospitalBooking(HospitalBooking hospitalBooking) {
        this.hospitalBooking = hospitalBooking;
    }

    /**
     * Gets reason.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets reason.
     *
     * @param reason the reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets animal.
     *
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Sets animal.
     *
     * @param animal the animal
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /**
     * Gets needs additional assistant.
     *
     * @return the needs additional assistant
     */
    public Boolean getNeedsAdditionalAssistant() {
        return needsAdditionalAssistant;
    }

    /**
     * Sets needs additional assistant.
     *
     * @param needsAdditionalAssistant the needs additional assistant
     */
    public void setNeedsAdditionalAssistant(Boolean needsAdditionalAssistant) {
        this.needsAdditionalAssistant = needsAdditionalAssistant;
    }

    /**
     * Gets additional sur charge.
     *
     * @return the additional sur charge
     */
    public Boolean getAdditionalSurCharge() {
        return additionalSurCharge;
    }

    /**
     * Sets additional sur charge.
     *
     * @param additionalSurCharge the additional sur charge
     */
    public void setAdditionalSurCharge(Boolean additionalSurCharge) {
        this.additionalSurCharge = additionalSurCharge;
    }

    /**
     * Gets long distance.
     *
     * @return the long distance
     */
    public Boolean getLongDistance() {
        return longDistance;
    }

    /**
     * Sets long distance.
     *
     * @param longDistance the long distance
     */
    public void setLongDistance(Boolean longDistance) {
        this.longDistance = longDistance;
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
