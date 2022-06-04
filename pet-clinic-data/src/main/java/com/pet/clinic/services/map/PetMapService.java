package com.pet.clinic.services.map;

import com.pet.clinic.model.Pet;
import com.pet.clinic.services.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile({"map","default"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
