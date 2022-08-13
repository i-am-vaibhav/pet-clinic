package com.pet.clinic.controller;

import com.pet.clinic.model.Owner;
import com.pet.clinic.services.OwnerService;
import com.pet.clinic.services.map.AbstractMapService;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest extends AbstractMapService {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(1l);
        Owner owner2 = new Owner();
        owner.setId(2l);
        owner.setMobile("1234567");
        owners.add(owner);
        owners.add(owner2);

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception{
        Mockito.when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/")).andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.view().name("owners/index")).
                andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find")).andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.view().name("notImplemented"));

        Mockito.verifyNoInteractions(ownerService);
    }
}