package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue
    @Column(name = "hospital_id")
    private Long hospitalId;
    private String hospitalName;
    private String hospitalDescription;
    private LocalTime hospitalStartTime;
    private LocalTime hospitalEndTime;
    @CreatedDate
    private LocalDateTime createdTime;
    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;


    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalDescription() {
        return hospitalDescription;
    }

    public void setHospitalDescription(String hospitalDescription) {
        this.hospitalDescription = hospitalDescription;
    }

    public LocalTime getHospitalStartTime() {
        return hospitalStartTime;
    }

    public void setHospitalStartTime(LocalTime hospitalStartTime) {
        this.hospitalStartTime = hospitalStartTime;
    }

    public LocalTime getHospitalEndTime() {
        return hospitalEndTime;
    }

    public void setHospitalEndTime(LocalTime hospitalEndTime) {
        this.hospitalEndTime = hospitalEndTime;
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
}
