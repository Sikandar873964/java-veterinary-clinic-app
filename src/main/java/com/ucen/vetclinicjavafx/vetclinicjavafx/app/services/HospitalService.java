package com.ucen.vetclinicjavafx.vetclinicjavafx.app.services;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBooking;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBookingItem;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos.HospitalBookingItemRepo;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos.HospitalBookingRepo;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Hospital service.
 */
@Service
public class HospitalService extends AbstractService {

    @Autowired
    private HospitalRepo hospitalRepo;
    @Autowired
    private HospitalBookingRepo hospitalBookingRepo;
    @Autowired
    private HospitalBookingItemRepo hospitalBookingItemRepo;

    /**
     * Create hospital hospital.
     *
     * @param hospital the hospital
     * @return the hospital
     */
    public Hospital createHospital(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    /**
     * Gets hospital.
     *
     * @param id the id
     * @return the hospital
     */
    public Hospital getHospital(Long id) {
        return hospitalRepo.getReferenceById(id);
    }

    /**
     * Update hospital.
     *
     * @param hospital the hospital
     */
    public void updateHospital(Hospital hospital) {
        hospitalRepo.save(hospital);
    }

    /**
     * Find all hospitals page.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @param direction  the direction
     * @param properties the properties
     * @return the page
     */
    public Page<Hospital> findAllHospitals(Integer pageNumber, Integer pageSize, Sort.Direction direction,
                                           String... properties) {
        return hospitalRepo.findAll(createPageableRequest(pageNumber, pageSize, direction, properties));
    }

    /**
     * Create hospital booking hospital booking.
     *
     * @param hospitalBooking the hospital booking
     * @return the hospital booking
     */
    public HospitalBooking createHospitalBooking(HospitalBooking hospitalBooking) {
        return hospitalBookingRepo.save(hospitalBooking);
    }

    /**
     * Update hospital booking.
     *
     * @param hospitalBooking the hospital booking
     */
    public void updateHospitalBooking(HospitalBooking hospitalBooking) {
         hospitalBookingRepo.save(hospitalBooking);
    }

    /**
     * Gets hospital booking.
     *
     * @param id the id
     * @return the hospital booking
     */
    public HospitalBooking getHospitalBooking(Long id) {
        return hospitalBookingRepo.getReferenceById(id);
    }

    /**
     * Gets hospital bookings by hospital.
     *
     * @param hospital   the hospital
     * @param page       the page
     * @param pageSize   the page size
     * @param direction  the direction
     * @param properties the properties
     * @return the hospital bookings by hospital
     */
    public Page<HospitalBooking> getHospitalBookingsByHospital(Hospital hospital, Integer page, Integer pageSize,
                                                               Sort.Direction direction, String... properties) {
        return hospitalBookingRepo.getByHospital(hospital,
                createPageableRequest(page, pageSize, direction, properties));
    }

    /**
     * Gets hospital bookings by customer.
     *
     * @param customer   the customer
     * @param page       the page
     * @param pageSize   the page size
     * @param direction  the direction
     * @param properties the properties
     * @return the hospital bookings by customer
     */
    public Page<HospitalBooking> getHospitalBookingsByCustomer(Customer customer, Integer page, Integer pageSize,
                                                               Sort.Direction direction, String... properties) {
        return hospitalBookingRepo.getByCustomer(customer,
                createPageableRequest(page, pageSize, direction, properties));
    }

    /**
     * Create hospital booking item hospital booking item.
     *
     * @param hospitalBookingItem the hospital booking item
     * @return the hospital booking item
     */
    public HospitalBookingItem createHospitalBookingItem(HospitalBookingItem hospitalBookingItem){
        return hospitalBookingItemRepo.save(hospitalBookingItem);
    }

    /**
     * Create hospital booking items list.
     *
     * @param hospitalBookingItems the hospital booking items
     * @return the list
     */
    public List<HospitalBookingItem> createHospitalBookingItems(List<HospitalBookingItem> hospitalBookingItems){
        return hospitalBookingItemRepo.saveAll(hospitalBookingItems);
    }

    /**
     * Get hospital booking item hospital booking item.
     *
     * @param hopitalBookingItemId the hopital booking item id
     * @return the hospital booking item
     */
    public HospitalBookingItem getHospitalBookingItem(Long hopitalBookingItemId){
        return hospitalBookingItemRepo.getReferenceById(hopitalBookingItemId);
    }
}
