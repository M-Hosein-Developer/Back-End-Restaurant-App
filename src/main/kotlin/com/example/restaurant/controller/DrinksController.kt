package com.example.restaurant.controller

import com.example.restaurant.model.Drinks
import com.example.restaurant.model.FastFood
import com.example.restaurant.repository.DrinksRepository
import com.example.restaurant.repository.FastFoodRepository
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DrinksController {

    lateinit var drinksRepository: DrinksRepository

    @Autowired
    fun set_drinks_repository(drinkRepository: DrinksRepository){
        drinksRepository = drinkRepository
    }

    @GetMapping("/getDrinks")
    fun getAllDrinks() : ResponseEntity<MutableIterable<Drinks>>{
        val dataFromDatabase = drinksRepository.findAll()
        return ResponseEntity.ok(dataFromDatabase)
    }

    @PostMapping("/insertDrinks")
    fun insertDrinks(@RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , Drinks::class.java)

        drinksRepository.save(newFastFood)

    }

    @PutMapping("/drinks/update{id}")
    fun updateDrinks(@PathVariable("id") id: Int , @RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , Drinks::class.java)

        drinksRepository.save(newFastFood)

    }

    @DeleteMapping("/drinks/deleting{id}")
    fun deleteDrinks(@PathVariable("id") id : Int){

        drinksRepository.deleteById(id)

    }

}