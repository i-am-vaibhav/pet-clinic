package com.pet.clinic.services.map;

import com.pet.clinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest extends AbstractMapService {

    private OwnerMapService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        Owner save = new Owner();
        save.setId(1l);
        save.setLastName("lastName");
        ownerService.save(save);
    }

    @Test
    void testFindAll() {
        Set<Owner> owners = ownerService.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void testFindById() {
        Owner obj = ownerService.findById(1l);
        assertNotNull(obj);
        assertEquals(obj.getId(),1l);
    }

    @Test
    void testDeleteById() {
        ownerService.deleteById(1l);
        Owner obj = ownerService.findById(1l);
        assertNull(obj);
    }

    @Test
    void testDelete() {
        Owner obj = ownerService.findById(1l);
        ownerService.delete(obj);
        Owner obj1 = ownerService.findById(1l);
        assertNull(obj1);
    }

    @Test
    void findByLastName() {
        Owner lastName = ownerService.findByLastName("lastName");
        assertNotNull(lastName);
        assertEquals(lastName.getLastName(),"lastName");
    }

    @Test
    void testSave() {
        Owner save = new Owner();
        save.setLastName("lastName");
        Owner owner = ownerService.save(save);
        assertNotNull(owner);
        assertNotNull(owner.getId());
        assertEquals(owner.getLastName(),save.getLastName());
    }
}