package com.abc.demo.DoctorApp.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.demo.DoctorApp.ENTITY.DoctorEntity;


@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {

}
