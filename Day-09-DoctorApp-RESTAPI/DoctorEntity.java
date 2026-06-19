package com.abc.demo.DoctorApp.ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @NotBlank(message = "Doctor name cannot be empty")
    @Size(
            min = 3,
            max = 50,
            message = "Doctor name should contain minimum 3 and maximum 50 characters"
    )
    private String doctorName;

    @Min(value = 25, message = "Minimum age required is 25 years")
    @Max(value = 60, message = "Maximum age allowed is 60 years")
    private int doctorAge;

    @NotBlank(message = "Doctor speciality cannot be empty")
    private String doctorSpeciality;

    @Positive(message = "Doctor salary must be greater than 0")
    private int doctorSalary;

    public DoctorEntity() {
    }

    public DoctorEntity(Integer doctorId, String doctorName, int doctorAge,
                        String doctorSpeciality, int doctorSalary) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorAge = doctorAge;
        this.doctorSpeciality = doctorSpeciality;
        this.doctorSalary = doctorSalary;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(int doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public int getDoctorSalary() {
        return doctorSalary;
    }

    public void setDoctorSalary(int doctorSalary) {
        this.doctorSalary = doctorSalary;
    }
}