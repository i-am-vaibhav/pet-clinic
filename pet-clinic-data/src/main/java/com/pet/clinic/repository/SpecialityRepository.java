package com.pet.clinic.repository;

import com.pet.clinic.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends
        JpaRepository<Speciality,Long> {
}
