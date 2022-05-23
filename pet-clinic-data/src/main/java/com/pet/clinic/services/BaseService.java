package com.pet.clinic.services;

import java.util.Set;

public interface BaseService<T,Id> {

    Set<T> findAll();

    T findById(Id id);

    T save(T object);

    void delete(T object);

    void deleteById(Id id);

}
