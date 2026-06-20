package com.abc.demo.HospitalApp.ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hospitals")
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospitalId;

    @NotBlank(message = "Hospital name cannot be empty")
    @Size(
        min = 3,
        max = 50,
        message = "Hospital name should contain minimum 3 and maximum 50 characters"
    )
    private String hospitalName;

    @NotBlank(message = "Hospital location cannot be empty")
    private String hospitalLocation;

    public HospitalEntity() {
    }

    public HospitalEntity(Integer hospitalId,
                          String hospitalName,
                          String hospitalLocation) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalLocation = hospitalLocation;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }
}