package com.example.restaurant.controller

import com.example.restaurant.model.Desserts
import com.example.restaurant.model.FastFood
import com.example.restaurant.repository.DessertsRepository
import com.example.restaurant.repository.FastFoodRepository
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DessertsController {

    lateinit var dessertsRepository: DessertsRepository

    @Autowired
    fun set_desserts_repository(dessertsRepository1: DessertsRepository){
        dessertsRepository = dessertsRepository1
    }

    @GetMapping("/getAllDesserts")
    fun getAllDesserts() : ResponseEntity<MutableIterable<Desserts>>{
        val dataFromDatabase = dessertsRepository.findAll()
        return ResponseEntity.ok(dataFromDatabase)
    }

    @PostMapping("/insertDesserts")
    fun insertDesserts(@RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , Desserts::class.java)

        dessertsRepository.save(newFastFood)

    }



    @PutMapping("/desserts/update{id}")
    fun updateDesserts(@PathVariable("id") id: Int , @RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , Desserts::class.java)

        dessertsRepository.save(newFastFood)

    }

    @DeleteMapping("/desserts/deleting{id}")
    fun deleteDesserts(@PathVariable("id") id : Int){

        dessertsRepository.deleteById(id)

    }

}