package com.example.restaurant.controller

import com.example.restaurant.model.OrderFood
import com.example.restaurant.repository.OrderRepository
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class OrderController {

    lateinit var orderRepository: OrderRepository

    @Autowired
    fun set_order_repository(orderRepository1: OrderRepository){
        orderRepository = orderRepository1
    }

    @GetMapping("/getAllOrder")
    fun getAllOrder() : ResponseEntity<MutableIterable<OrderFood>>{
        val dataFromDatabase = orderRepository.findAll()
        return ResponseEntity.ok(dataFromDatabase)
    }

    @PostMapping("/insertOrder")
    fun insertOrder(@RequestBody data : String){

        val gson = Gson()
        val newOrder = gson.fromJson(data , OrderFood::class.java)

        orderRepository.save(newOrder)

    }



    @PutMapping("/order/update{id}")
    fun updateOrder(@PathVariable("id") id: Int , @RequestBody data : String){

        val gson = Gson()
        val newOrder = gson.fromJson(data , OrderFood::class.java)

        orderRepository.save(newOrder)

    }

    @DeleteMapping("/order/deleting{id}")
    fun deleteOrder(@PathVariable("id") id : Int){

        orderRepository.deleteById(id)

    }

}