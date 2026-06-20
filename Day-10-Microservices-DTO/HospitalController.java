package com.abc.demo.HospitalApp.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abc.demo.HospitalApp.DTO.HospitalDTO;
import com.abc.demo.HospitalApp.ENTITY.HospitalEntity;
import com.abc.demo.HospitalApp.SERVICE.HospitalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/create")
    public String createHospital(
            @Valid @RequestBody HospitalEntity hospitalDetails) {

        hospitalService.createHospital(hospitalDetails);

        return "Data Successfully Inserted!";
    }

    @GetMapping("/all")
    public List<HospitalEntity> getAllHospitals() {

        return hospitalService.readAllHospitals();
    }

    @GetMapping("/{hospitalId}")
    public HospitalDTO getParticularHospital(
            @PathVariable Integer hospitalId) {

        return hospitalService.readParticularHospital(hospitalId);
    }

    @DeleteMapping("/{hospitalId}")
    public String deleteHospital(
            @PathVariable Integer hospitalId) {

        return hospitalService.deleteParticularHospital(hospitalId);
    }
}