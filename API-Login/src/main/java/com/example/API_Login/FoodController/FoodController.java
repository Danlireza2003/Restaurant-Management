package com.example.API_Login.FoodController;

import com.example.API_Login.Food.Food;
import com.example.API_Login.Food.FoodDTO;
import com.example.API_Login.Food.FoodRepository;
import com.example.API_Login.Food.FoodRequestDTO;
import com.example.API_Login.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<Void> saveFood(@RequestBody FoodRequestDTO data) {
        foodService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<FoodDTO>> getAll() {
        List<FoodDTO> list = foodService.findAll();

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FoodDTO> updateFood(@PathVariable Long id,@RequestBody FoodRequestDTO data){
        FoodDTO updated = foodService.update(id, data);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteFood(@PathVariable Long id){
        boolean deleted = foodService.deleteFood(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();

        }
    }


}