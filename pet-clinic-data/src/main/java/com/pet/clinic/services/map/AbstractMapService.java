package com.pet.clinic.services.map;

import com.pet.clinic.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T t) {
        if (t != null) {
            t.setId(getNextId());
            map.put(t.getId(), t);
            return t;
        } else {
            throw new RuntimeException("Object cannot be null");
        }
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T t) {
        map.entrySet().removeIf(e -> e.getValue().equals(t));
    }

    private Long getNextId() {
        Long max;
        try {
            max = Collections.max(map.keySet());
        } catch (Exception e) {
            return 1l;
        }
        return max + 1;
    }

}
