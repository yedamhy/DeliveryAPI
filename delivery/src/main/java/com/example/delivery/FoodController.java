package com.example.delivery;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService service;


    public FoodController(FoodService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food){
        Food createFood = service.createAndUpdateFood(food);
        return ResponseEntity.ok(createFood);
    }

    @GetMapping
    public ResponseEntity<Food> getFood(@PathVariable int id) {
        return service.getFood(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Collection<Food> getAllFoods() {
        return service.getAllFoods();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable int id, @RequestBody Food food) {
        food.setId(id);
        Food updatedFood = service.createAndUpdateFood(food);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable int id) {
        service.deleteFood(id);
        return ResponseEntity.ok().build();
    }

}
