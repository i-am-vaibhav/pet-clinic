package com.pet.clinic.services.map;

import com.pet.clinic.model.Visit;
import com.pet.clinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile({"map","default"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if (visit != null)
            if (visit.getPet() == null || visit.getPet().getId() == null) throw new RuntimeException("Invalid visit");
        return super.save(visit);
    }
}
