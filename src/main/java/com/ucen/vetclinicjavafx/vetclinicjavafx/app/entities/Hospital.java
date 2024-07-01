package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * The type Hospital.
 */
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


    /**
     * Gets hospital id.
     *
     * @return the hospital id
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * Sets hospital id.
     *
     * @param hospitalId the hospital id
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * Gets hospital name.
     *
     * @return the hospital name
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * Sets hospital name.
     *
     * @param hospitalName the hospital name
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * Gets hospital description.
     *
     * @return the hospital description
     */
    public String getHospitalDescription() {
        return hospitalDescription;
    }

    /**
     * Sets hospital description.
     *
     * @param hospitalDescription the hospital description
     */
    public void setHospitalDescription(String hospitalDescription) {
        this.hospitalDescription = hospitalDescription;
    }

    /**
     * Gets hospital start time.
     *
     * @return the hospital start time
     */
    public LocalTime getHospitalStartTime() {
        return hospitalStartTime;
    }

    /**
     * Sets hospital start time.
     *
     * @param hospitalStartTime the hospital start time
     */
    public void setHospitalStartTime(LocalTime hospitalStartTime) {
        this.hospitalStartTime = hospitalStartTime;
    }

    /**
     * Gets hospital end time.
     *
     * @return the hospital end time
     */
    public LocalTime getHospitalEndTime() {
        return hospitalEndTime;
    }

    /**
     * Sets hospital end time.
     *
     * @param hospitalEndTime the hospital end time
     */
    public void setHospitalEndTime(LocalTime hospitalEndTime) {
        this.hospitalEndTime = hospitalEndTime;
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
}
