package com.example.restaurant.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class OrderFood(

        @Id
        val id: Int ,

        val name : String,
        val tableNumber : String
){
        constructor() : this(0 , "" , "")
}
