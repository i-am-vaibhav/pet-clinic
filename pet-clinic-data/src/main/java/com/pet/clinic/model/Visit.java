package com.pet.clinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(exclude = "pet")
@Entity
public class Visit extends BaseEntity {

    private LocalDate visitDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
