package com.abc.demo.DoctorApp.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;


import com.abc.demo.DoctorApp.ENTITY.DoctorEntity;
import com.abc.demo.DoctorApp.SERVICE.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create")
    public String createDoctor(@Valid @RequestBody DoctorEntity doctorDetails) {

        doctorService.createDoctor(doctorDetails);

        return "Data Successfully Inserted!";
    }

    @GetMapping("/all")
    public List<DoctorEntity> getAllDoctors() {

        return doctorService.readAllDoctors();
    }
    
    @GetMapping("/{doctorId}")
    public DoctorEntity getParticularDoctor(@PathVariable Integer doctorId) {

        return doctorService.readParticularDoctor(doctorId);
    }
    
    @DeleteMapping("/{doctorId}")
    public String deleteDoctor(@PathVariable Integer doctorId) {

        return doctorService.deleteParticularDoctor(doctorId);
    }
}