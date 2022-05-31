package com.pet.clinic.model;

import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPet(Set<Pet> pets) {
        this.pets = pets;
    }
}
