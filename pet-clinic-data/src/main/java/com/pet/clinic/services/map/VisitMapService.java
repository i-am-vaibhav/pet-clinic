package com.pet.clinic.services.map;

import com.pet.clinic.model.Visit;
import com.pet.clinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if (visit != null)
            if (visit.getPet() == null || visit.getPet().getId() == null) throw new RuntimeException("Invalid visit");
        return super.save(visit);
    }
}
