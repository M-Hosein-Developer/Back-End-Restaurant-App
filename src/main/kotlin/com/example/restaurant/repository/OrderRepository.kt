package com.example.restaurant.repository

import com.example.restaurant.model.OrderFood
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<OrderFood , Int> {

}