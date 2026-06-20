package com.abc.demo.HospitalApp.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.demo.HospitalApp.DTO.HospitalDTO;
import com.abc.demo.HospitalApp.ENTITY.HospitalEntity;
import com.abc.demo.HospitalApp.REPOSITORY.HospitalRepository;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public void createHospital(HospitalEntity hospitalDetails) {

        hospitalRepository.save(hospitalDetails);
    }

    public List<HospitalEntity> readAllHospitals() {

        return hospitalRepository.findAll();
    }

    public HospitalDTO readParticularHospital(Integer hospitalId) {

        HospitalEntity hospitalInfo =
                hospitalRepository.findById(hospitalId).get();

        HospitalDTO dto = new HospitalDTO();

        dto.setHospitalId(hospitalInfo.getHospitalId());
        dto.setHospitalName(hospitalInfo.getHospitalName());
        dto.setHospitalLocation(hospitalInfo.getHospitalLocation());

        return dto;
    }

    public String deleteParticularHospital(Integer hospitalId) {

        hospitalRepository.deleteById(hospitalId);

        return "Hospital Deleted Successfully";
    }
}