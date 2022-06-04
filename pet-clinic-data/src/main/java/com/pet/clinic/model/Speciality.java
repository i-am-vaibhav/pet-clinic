package com.pet.clinic.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
public class Speciality extends BaseEntity {

    private String description;

}
