package com.example.restaurant.controller

import com.example.restaurant.model.FastFood
import com.example.restaurant.repository.FastFoodRepository
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class FastFoodController {

    lateinit var fastFoodRepository : FastFoodRepository

    @Autowired
    fun set_fastfood_repository(fastFoodRepository1: FastFoodRepository){
        fastFoodRepository = fastFoodRepository1
    }

    @GetMapping("/getAllFastFood")
    fun getAllFastFood() : ResponseEntity<MutableIterable<FastFood>>{
        val dataFromDatabase = fastFoodRepository.findAll()
        return ResponseEntity.ok(dataFromDatabase)
    }

    @PostMapping("/insertFastFood")
    fun insertFastFood(@RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , FastFood::class.java)

        fastFoodRepository.save(newFastFood)

    }



    @PutMapping("/fastFood/update{id}")
    fun updateFastFood(@PathVariable("id") id: Int , @RequestBody data : String){

        val gson = Gson()
        val newFastFood = gson.fromJson(data , FastFood::class.java)

        fastFoodRepository.save(newFastFood)

    }

    @DeleteMapping("/fastFood/deleting{id}")
    fun deleteFastFood(@PathVariable("id") id : Int){

        fastFoodRepository.deleteById(id)

    }

}