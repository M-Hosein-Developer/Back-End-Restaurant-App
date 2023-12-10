package com.example.restaurant.controller

import com.example.restaurant.model.FastFood
import com.example.restaurant.model.Food
import com.example.restaurant.repository.FastFoodRepository
import com.example.restaurant.repository.FoodRepository
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class FoodController {

    lateinit var foodRepository : FoodRepository

    @Autowired
    fun set_food_repository(foodRepository1: FoodRepository){
        foodRepository = foodRepository1
    }

    @GetMapping("/getAllFood")
    fun getAllFood() : ResponseEntity<MutableIterable<Food>>{
        val dataFromDatabase = foodRepository.findAll()
        return ResponseEntity.ok(dataFromDatabase)
    }

    @PostMapping("/insertFood")
    fun insertFood(@RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , Food::class.java)

        foodRepository.save(newFastFood)

    }

    @PutMapping("/Food/update{id}")
    fun updateFood(@PathVariable("id") id: Int , @RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , Food::class.java)

        foodRepository.save(newFastFood)

    }

    @DeleteMapping("/Food/deleting{id}")
    fun deleteFood(@PathVariable("id") id : Int){

        foodRepository.deleteById(id)

    }

}