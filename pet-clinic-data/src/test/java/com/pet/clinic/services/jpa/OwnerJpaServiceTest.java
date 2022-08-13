package com.pet.clinic.services.jpa;

import com.pet.clinic.model.Owner;
import com.pet.clinic.repository.OwnerRepository;
import com.pet.clinic.repository.PetRepository;
import com.pet.clinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerJpaService ownerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testFindAll() {
        List<Owner> ownerList = new ArrayList<>();
        Owner owner = new Owner();
        owner.setId(1l);
        ownerList.add(owner);
        Mockito.when(ownerRepository.findAll()).thenReturn(ownerList);
        Set<Owner> owners = ownerService.findAll();
        assertEquals(1,owners.size());
        Mockito.verify(ownerRepository,Mockito.times(1)).findAll();
    }

    @Test
    void testFindById() {
        Owner owner = new Owner();
        owner.setId(1l);
        Mockito.when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner owners = ownerService.findById(1l);
        assertNotNull(owners);
        assertEquals(1l,owners.getId());
        Mockito.verify(ownerRepository,Mockito.times(1)).findById(any());
    }

    @Test
    void testSave() {
        Owner owner = new Owner();
        owner.setId(1l);
        Mockito.when(ownerRepository.save(any())).thenReturn(owner);
        Owner owners = ownerService.save(owner);
        assertNotNull(owners);
        Mockito.verify(ownerRepository,Mockito.times(1)).save(any());
    }

    @Test
    void testDelete() {
        Owner owner = new Owner();
        owner.setId(1l);
        ownerService.delete(owner);
        Mockito.verify(ownerRepository,Mockito.times(1)).delete(any());
    }

    @Test
    void testDeleteById() {
        Owner owner = new Owner();
        owner.setId(1l);
        ownerService.deleteById(1l);
        Mockito.verify(ownerRepository,Mockito.times(1)).deleteById(any());
    }

    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setId(1l);
        owner.setLastName("lastname");
        Mockito.when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(owner));
        Owner owners = ownerService.findByLastName("lastname");
        assertNotNull(owners);
        Mockito.verify(ownerRepository,Mockito.times(1)).findByLastName(any());
    }
}