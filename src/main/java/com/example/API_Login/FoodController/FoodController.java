package com.example.API_Login.FoodController;

import com.example.API_Login.Food.Food;
import com.example.API_Login.Food.FoodRepository;
import com.example.API_Login.Food.FoodRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")

public class FoodController {
    @Autowired
    private FoodRepository repository;
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData=new Food(data);
        repository.save(foodData);
        return;
    }
    @CrossOrigin(origins ="*",allowedHeaders = "*")
    @GetMapping
    public List<Food>getAll(){
        List<Food>foodList=repository.findAll();
        return foodList;
    }

}
