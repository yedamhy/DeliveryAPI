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

    // Service 에서 DTO로 받고 Client에게 보여주기 전에 Entity
    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food){
        // DTO 로 받아서 Entity로 변환
        Food food = convertToEntity(foodDTO);
        Food createFood = service.createAndUpdateFood(food);
        return ResponseEntity.ok(convertToDTO(createFood));
    }

    @GetMapping
    public ResponseEntity<Food> getFood(@PathVariable int id) {
        //TODO  여기가 헷갈리고 이해가 잘 안된다,,,!!
        List<Food> foods = service.getAllFoods();
        List<FoodDTO> foodDTOs = foods.stream()
                .map(this::converToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(foodDTOs);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable int id, @RequestBody Food food) {
        Food food = convertToEntity(foodDTO);
        food.setId(id);
        Food updatedFood = service.createAndUpdateFood(food);
        return ResponseEntity.ok(convertToDTO(updatedFood));
        //TODO 왜 다시 반환해서 return 하지..?
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable int id) {
        service.deleteFood(id);
        return ResponseEntity.ok().build();
    }

    // Entity -> DTO
    private FoodDTO convertToDTO(Food food) {
        FoodDTO dto = new FoodDTO();
        dto.setId(food.getId());
        dto.setName(food.getName());
        dto.setDescription(food.getDescription());
        dto.setPrice(food.getPrice());
        dto.setCategory(food.getCategory());
        return dto;
    }

    // DTO -> Entity
    private Food convertToEntity(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setDescription(foodDTO.getDescription());
        food.setPrice(foodDTO.getPrice());
        food.setCategory(foodDTO.getCategory());
        return food;
    }

}
