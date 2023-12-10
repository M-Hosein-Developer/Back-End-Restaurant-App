package com.example.restaurant.repository

import com.example.restaurant.model.Desserts
import com.example.restaurant.model.FastFood
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DessertsRepository : CrudRepository<Desserts , Int> {

}