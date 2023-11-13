package com.example.delivery;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MapRepository {
    private final Map<Integer, Food> db = new HashMap<>();
    private int currentId = 1;

    public Food save(Food food){
        if(food.getId() == null){
            food.setId(currentId++);
        }
        db.put(food.getId(), food);
        return food;
    }

    public Optional<Food> findById(int id) { // Null Pointer Exception 방지
        return Optional.ofNullable(db.get(id));
    }

    public Collection<Food> findAll() {
        return db.values();
    }

    public void delete(int id) {
        db.remove(id);
    }
}
