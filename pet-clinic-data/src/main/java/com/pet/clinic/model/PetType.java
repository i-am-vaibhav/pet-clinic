package com.pet.clinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {

    private String name;

}
