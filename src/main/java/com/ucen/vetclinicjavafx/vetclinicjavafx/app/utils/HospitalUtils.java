package com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * The type Hospital utils.
 */
@Component
public class HospitalUtils {

    /**
     * Create hospital hospital.
     *
     * @param hospitalName        the hospital name
     * @param hospitalDescription the hospital description
     * @param startTime           the start time
     * @param endTime             the end time
     * @return the hospital
     */
    public Hospital createHospital(String hospitalName, String hospitalDescription, LocalTime startTime,
                                   LocalTime endTime) {
        Hospital hospital = new Hospital();
        hospital.setHospitalName(hospitalName);
        hospital.setHospitalDescription(hospitalDescription);
        hospital.setHospitalStartTime(startTime);
        hospital.setHospitalEndTime(endTime);

        return hospital;
    }

    /**
     * Create hospital booking hospital booking.
     *
     * @param hospital  the hospital
     * @param customer  the customer
     * @param startTime the start time
     * @param endTime   the end time
     * @return the hospital booking
     */
    public HospitalBooking createHospitalBooking(Hospital hospital, Customer customer, LocalDateTime startTime,
                                                 LocalDateTime endTime) {
        HospitalBooking hospitalBooking = new HospitalBooking();
        hospitalBooking.setCustomer(customer);
        hospitalBooking.setHospital(hospital);
        hospitalBooking.setStartTime(startTime);
        hospitalBooking.setEndTime(endTime);

        return hospitalBooking;
    }

    /**
     * Gets total item price for booking.
     *
     * @param hospitalBookingItems the hospital booking items
     * @return the total item price for booking
     */
    public Double getTotalItemPriceForBooking(List<HospitalBookingItem> hospitalBookingItems) {
        double sum = 0;
        if (CollectionUtils.isNotEmpty(hospitalBookingItems)) {
            for (HospitalBookingItem hospitalBookItem :
                    hospitalBookingItems) {
                sum = sum + hospitalBookItem.getPrice();
            }
        }
        return sum;
    }

    /**
     * Create hospital booking item object hospital booking item.
     *
     * @param animal                   the animal
     * @param reason                   the reason
     * @param longDistance             the long distance
     * @param additionalSurCharge      the additional sur charge
     * @param needsAdditionalAssistant the needs additional assistant
     * @return the hospital booking item
     */
    public HospitalBookingItem createHospitalBookingItemObject(Animal animal, String reason,boolean longDistance,
                                                               boolean additionalSurCharge,
                                                               boolean needsAdditionalAssistant) {
        HospitalBookingItem hospitalBookingItem = new HospitalBookingItem();
        hospitalBookingItem.setAnimal(animal);
        hospitalBookingItem.setReason(reason);
        hospitalBookingItem.setLongDistance(longDistance);
        hospitalBookingItem.setNeedsAdditionalAssistant(needsAdditionalAssistant);
        hospitalBookingItem.setAdditionalSurCharge(additionalSurCharge);
        hospitalBookingItem.setPrice(getPriceForHospitalBookingItem(hospitalBookingItem));
        return hospitalBookingItem;
    }

    /**
     * Gets price for hospital booking item.
     *
     * @param hospitalBookingItem the hospital booking item
     * @return the price for hospital booking item
     */
    public static Double getPriceForHospitalBookingItem(HospitalBookingItem hospitalBookingItem) {
        long basePrice = hospitalBookingItem.getAnimal().getPrice();
        long finalPrice = basePrice;
        if (hospitalBookingItem.getLongDistance()) {
            finalPrice = finalPrice + 12;
        }
        if (hospitalBookingItem.getAdditionalSurCharge()) {
            finalPrice = finalPrice + 10;
        }
        if (hospitalBookingItem.getNeedsAdditionalAssistant()) {
            finalPrice = finalPrice + 5;
        }
        return Double.valueOf(finalPrice);
    }
}

