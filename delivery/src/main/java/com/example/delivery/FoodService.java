package com.example.delivery;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Optional;

@Service
public class FoodService {
    private final MapRepository repository;


    public FoodService(MapRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Food createAndUpdateFood(Food food){
        return repository.save(food);
    }

    public Optional<Food> getFood(int id) {
        return repository.findById(id);
    }

    public Collection<Food> getAllFoods() {
        return repository.findAll();
    }

    public void deleteFood(int id) {
        repository.delete(id);
    }

}
