package com.abc.demo.DoctorApp.SERVICE;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.demo.DoctorApp.ENTITY.DoctorEntity;
import com.abc.demo.DoctorApp.REPOSITORY.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void createDoctor(DoctorEntity doctorDetails) {
        doctorRepository.save(doctorDetails);
    }

    public List<DoctorEntity> readAllDoctors() {
    	 return doctorRepository.findAll();
    }

    public DoctorEntity readParticularDoctor(Integer doctorId) {

        return doctorRepository.findById(doctorId).orElse(null);
    }
    public String deleteParticularDoctor(Integer doctorId) {

        doctorRepository.deleteById(doctorId);

        return "Doctor Deleted Successfully";
    }
}