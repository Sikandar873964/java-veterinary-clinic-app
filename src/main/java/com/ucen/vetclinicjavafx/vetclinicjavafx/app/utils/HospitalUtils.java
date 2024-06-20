package com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class HospitalUtils {

    public Hospital createHospital(String hospitalName, String hospitalDescription, LocalTime startTime,
                                   LocalTime endTime) {
        Hospital hospital = new Hospital();
        hospital.setHospitalName(hospitalName);
        hospital.setHospitalDescription(hospitalDescription);
        hospital.setHospitalStartTime(startTime);
        hospital.setHospitalEndTime(endTime);

        return hospital;
    }

    public HospitalBooking createHospitalBooking(Hospital hospital, Customer customer, LocalDateTime startTime,
                                                 LocalDateTime endTime) {
        HospitalBooking hospitalBooking = new HospitalBooking();
        hospitalBooking.setCustomer(customer);
        hospitalBooking.setHospital(hospital);
        hospitalBooking.setStartTime(startTime);
        hospitalBooking.setEndTime(endTime);

        return hospitalBooking;
    }

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

    public Double getPriceForHospitalBookingItem(HospitalBookingItem hospitalBookingItem) {
        long basePrice = hospitalBookingItem.getAnimal().getPrice();
        long finalPrice = basePrice;
        if (hospitalBookingItem.getLongDistance()) {
            finalPrice = finalPrice + 10;
        }
        if (hospitalBookingItem.getAdditionalSurCharge()) {
            finalPrice = finalPrice + 20;
        }
        if (hospitalBookingItem.getNeedsAdditionalAssistant()) {
            finalPrice = finalPrice + 25;
        }
        return Double.valueOf(finalPrice);
    }
}

