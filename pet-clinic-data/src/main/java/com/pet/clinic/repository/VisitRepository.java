package com.pet.clinic.repository;

import com.pet.clinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends
        JpaRepository<Visit,Long> {
}
