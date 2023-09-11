package com.lmbaila.cardapio.controller;

import com.lmbaila.cardapio.food.Food;
import com.lmbaila.cardapio.food.FoodRepository;
import com.lmbaila.cardapio.food.FoodRequestDTO;
import com.lmbaila.cardapio.food.FoodResponseDTO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("food")
public class FoodController {
  @Autowired
  private FoodRepository repository;

  @GetMapping
  public List<FoodResponseDTO> getAll(){
   List<FoodResponseDTO> foodList  = repository.findAll().stream().map(FoodResponseDTO::new).toList();
   return foodList;
  }
 
  @PostMapping
  public void saveFood(@RequestBody FoodRequestDTO data){
    Food foodData = new Food(data);
    repository.save(foodData);
    return;

  }
}
