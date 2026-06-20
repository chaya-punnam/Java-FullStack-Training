package com.abc.demo.HospitalApp.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.demo.HospitalApp.ENTITY.HospitalEntity;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {

}