package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.HospitalUtils;
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
    private String animalName;
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
     * Gets animal name.
     *
     * @return the animal name
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * Sets animal name.
     *
     * @param animalName the animal name
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
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


    /**
     * The type Hospital booking item builder.
     */
    public static final class HospitalBookingItemBuilder {
        private Long hospitalBookingId;
        private HospitalBooking hospitalBooking;
        private String reason;
        private Animal animal;
        private String animalName;
        private Boolean needsAdditionalAssistant;
        private Boolean additionalSurCharge;
        private Boolean longDistance;
        private Double price;

        private HospitalBookingItemBuilder() {
        }

        /**
         * A hospital booking item hospital booking item builder.
         *
         * @return the hospital booking item builder
         */
        public static HospitalBookingItemBuilder aHospitalBookingItem() {
            return new HospitalBookingItemBuilder();
        }

        /**
         * With hospital booking id hospital booking item builder.
         *
         * @param hospitalBookingId the hospital booking id
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withHospitalBookingId(Long hospitalBookingId) {
            this.hospitalBookingId = hospitalBookingId;
            return this;
        }

        /**
         * With hospital booking hospital booking item builder.
         *
         * @param hospitalBooking the hospital booking
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withHospitalBooking(HospitalBooking hospitalBooking) {
            this.hospitalBooking = hospitalBooking;
            return this;
        }

        /**
         * With reason hospital booking item builder.
         *
         * @param reason the reason
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withReason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * With animal hospital booking item builder.
         *
         * @param animal the animal
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withAnimal(Animal animal) {
            this.animal = animal;
            return this;
        }

        /**
         * With animal name hospital booking item builder.
         *
         * @param animalName the animal name
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withAnimalName(String animalName) {
            this.animalName = animalName;
            return this;
        }

        /**
         * With needs additional assistant hospital booking item builder.
         *
         * @param needsAdditionalAssistant the needs additional assistant
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withNeedsAdditionalAssistant(Boolean needsAdditionalAssistant) {
            this.needsAdditionalAssistant = needsAdditionalAssistant;
            return this;
        }

        /**
         * With additional sur charge hospital booking item builder.
         *
         * @param additionalSurCharge the additional sur charge
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withAdditionalSurCharge(Boolean additionalSurCharge) {
            this.additionalSurCharge = additionalSurCharge;
            return this;
        }

        /**
         * With long distance hospital booking item builder.
         *
         * @param longDistance the long distance
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withLongDistance(Boolean longDistance) {
            this.longDistance = longDistance;
            return this;
        }

        /**
         * With price hospital booking item builder.
         *
         * @param price the price
         * @return the hospital booking item builder
         */
        public HospitalBookingItemBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        /**
         * Build hospital booking item.
         *
         * @return the hospital booking item
         */
        public HospitalBookingItem build() {
            HospitalBookingItem hospitalBookingItem = new HospitalBookingItem();
            hospitalBookingItem.setHospitalBookingId(hospitalBookingId);
            hospitalBookingItem.setHospitalBooking(hospitalBooking);
            hospitalBookingItem.setReason(reason);
            hospitalBookingItem.setAnimal(animal);
            hospitalBookingItem.setAnimalName(animalName);
            hospitalBookingItem.setNeedsAdditionalAssistant(needsAdditionalAssistant);
            hospitalBookingItem.setAdditionalSurCharge(additionalSurCharge);
            hospitalBookingItem.setLongDistance(longDistance);
            hospitalBookingItem.setPrice(HospitalUtils.getPriceForHospitalBookingItem(hospitalBookingItem));
            return hospitalBookingItem;
        }
    }
}
