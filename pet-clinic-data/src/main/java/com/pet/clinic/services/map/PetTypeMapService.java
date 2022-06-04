package com.pet.clinic.services.map;

import com.pet.clinic.model.PetType;
import com.pet.clinic.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile({"map","default"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
