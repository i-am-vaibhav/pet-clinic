package com.pet.clinic.model;

import java.util.Set;

public class Owner extends Person {

    private String address;

    private String city;

    private String mobile;
    private Set<Pet> pets;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Set<Pet> getPets() {
        return pets;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }


}
