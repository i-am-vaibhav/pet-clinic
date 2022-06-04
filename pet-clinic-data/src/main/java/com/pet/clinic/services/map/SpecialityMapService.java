package com.pet.clinic.services.map;

import com.pet.clinic.model.Speciality;
import com.pet.clinic.services.SpecialityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile({"map","default"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
