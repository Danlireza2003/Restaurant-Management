package com.example.API_Login.Service;

import com.example.API_Login.Food.Food;
import com.example.API_Login.Food.FoodDTO;
import com.example.API_Login.Food.FoodRepository;
import com.example.API_Login.Food.FoodRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
public class FoodService {
    private final FoodRepository repository;
    public FoodService(FoodRepository repository){
        this.repository=repository;
    }
    public void create(FoodRequestDTO data){
        Food food = new Food(data);
        repository.save(food);
    }
    public List<FoodDTO>findAll(){
        List<Food> foods=repository.findAll();
        return foods.stream()
                .map(FoodDTO::new)
                .toList();
    }
    public FoodDTO update(Long id, FoodRequestDTO data) {
        Food food = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comida com ID " + id + " não encontrada"));

        food.setTitle(data.title());
        food.setImage(data.image());
        food.setPrice(data.price());

        repository.save(food);

        return new FoodDTO(food);


    }
    @Transactional
    public boolean deleteFood(Long id){
        Optional<Food>foodOptional=repository.findById(id);
        if(foodOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}