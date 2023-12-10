package com.example.restaurant.repository

import com.example.restaurant.model.Drinks
import com.example.restaurant.model.FastFood
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DrinksRepository : CrudRepository<Drinks , Int> {

}