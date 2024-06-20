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

@Service
public class HospitalService extends AbstractService {

    @Autowired
    private HospitalRepo hospitalRepo;
    @Autowired
    private HospitalBookingRepo hospitalBookingRepo;
    @Autowired
    private HospitalBookingItemRepo hospitalBookingItemRepo;

    public Hospital createHospital(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    public Hospital getHospital(Long id) {
        return hospitalRepo.getReferenceById(id);
    }

    public void updateHospital(Hospital hospital) {
        hospitalRepo.save(hospital);
    }

    public Page<Hospital> findAllHospitals(Integer pageNumber, Integer pageSize, Sort.Direction direction,
                                           String... properties) {
        return hospitalRepo.findAll(createPageableRequest(pageNumber, pageSize, direction, properties));
    }

    public HospitalBooking createHospitalBooking(HospitalBooking hospitalBooking) {
        return hospitalBookingRepo.save(hospitalBooking);
    }

    public void updateHospitalBooking(HospitalBooking hospitalBooking) {
         hospitalBookingRepo.save(hospitalBooking);
    }

    public HospitalBooking getHospitalBooking(Long id) {
        return hospitalBookingRepo.getReferenceById(id);
    }

    public Page<HospitalBooking> getHospitalBookingsByHospital(Hospital hospital, Integer page, Integer pageSize,
                                                               Sort.Direction direction, String... properties) {
        return hospitalBookingRepo.getByHospital(hospital,
                createPageableRequest(page, pageSize, direction, properties));
    }

    public Page<HospitalBooking> getHospitalBookingsByCustomer(Customer customer, Integer page, Integer pageSize,
                                                               Sort.Direction direction, String... properties) {
        return hospitalBookingRepo.getByCustomer(customer,
                createPageableRequest(page, pageSize, direction, properties));
    }

    public HospitalBookingItem createHospitalBookingItem(HospitalBookingItem hospitalBookingItem){
        return hospitalBookingItemRepo.save(hospitalBookingItem);
    }

    public List<HospitalBookingItem> createHospitalBookingItems(List<HospitalBookingItem> hospitalBookingItems){
        return hospitalBookingItemRepo.saveAll(hospitalBookingItems);
    }

    public HospitalBookingItem getHospitalBookingItem(Long hopitalBookingItemId){
        return hospitalBookingItemRepo.getReferenceById(hopitalBookingItemId);
    }
}
