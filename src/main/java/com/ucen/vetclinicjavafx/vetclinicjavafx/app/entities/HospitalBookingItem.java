package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.HospitalUtils;
import jakarta.persistence.*;

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

    public Long getHospitalBookingId() {
        return hospitalBookingId;
    }

    public void setHospitalBookingId(Long hospitalBookingId) {
        this.hospitalBookingId = hospitalBookingId;
    }

    public HospitalBooking getHospitalBooking() {
        return hospitalBooking;
    }

    public void setHospitalBooking(HospitalBooking hospitalBooking) {
        this.hospitalBooking = hospitalBooking;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Boolean getNeedsAdditionalAssistant() {
        return needsAdditionalAssistant;
    }

    public void setNeedsAdditionalAssistant(Boolean needsAdditionalAssistant) {
        this.needsAdditionalAssistant = needsAdditionalAssistant;
    }

    public Boolean getAdditionalSurCharge() {
        return additionalSurCharge;
    }

    public void setAdditionalSurCharge(Boolean additionalSurCharge) {
        this.additionalSurCharge = additionalSurCharge;
    }

    public Boolean getLongDistance() {
        return longDistance;
    }

    public void setLongDistance(Boolean longDistance) {
        this.longDistance = longDistance;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public static final class HospitalBookingItemBuilder {
        private HospitalBookingItem hospitalBookingItem;

        private HospitalBookingItemBuilder() {
            hospitalBookingItem = new HospitalBookingItem();
        }

        public static HospitalBookingItemBuilder aHospitalBookingItem() {
            return new HospitalBookingItemBuilder();
        }

        public HospitalBookingItemBuilder withHospitalBookingId(Long hospitalBookingId) {
            hospitalBookingItem.setHospitalBookingId(hospitalBookingId);
            return this;
        }

        public HospitalBookingItemBuilder withHospitalBooking(HospitalBooking hospitalBooking) {
            hospitalBookingItem.setHospitalBooking(hospitalBooking);
            return this;
        }

        public HospitalBookingItemBuilder withReason(String reason) {
            hospitalBookingItem.setReason(reason);
            return this;
        }

        public HospitalBookingItemBuilder withAnimal(Animal animal) {
            hospitalBookingItem.setAnimal(animal);
            return this;
        }

        public HospitalBookingItemBuilder withNeedsAdditionalAssistant(Boolean needsAdditionalAssistant) {
            hospitalBookingItem.setNeedsAdditionalAssistant(needsAdditionalAssistant);
            return this;
        }

        public HospitalBookingItemBuilder withAdditionalSurCharge(Boolean additionalSurCharge) {
            hospitalBookingItem.setAdditionalSurCharge(additionalSurCharge);
            return this;
        }

        public HospitalBookingItemBuilder withLongDistance(Boolean longDistance) {
            hospitalBookingItem.setLongDistance(longDistance);
            return this;
        }

        public HospitalBookingItemBuilder withPrice(Double price) {
            hospitalBookingItem.setPrice(price);
            return this;
        }

        public HospitalBookingItem build() {

            withPrice(HospitalUtils.getPriceForHospitalBookingItem(hospitalBookingItem));
            return hospitalBookingItem;
        }
    }
}
