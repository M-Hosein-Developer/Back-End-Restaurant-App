package com.example.restaurant.repository

import com.example.restaurant.model.FastFood
import com.example.restaurant.model.Food
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : CrudRepository<Food, Int> {

}