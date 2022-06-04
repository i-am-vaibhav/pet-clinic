package com.pet.clinic.repository;

import com.pet.clinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends
        JpaRepository<Vet,Long> {
}
