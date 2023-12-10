package com.example.restaurant.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class FastFood(

     @Id
     val id : Int ,

     val name : String ,
     val price : String ,
     val description : String ,
     val time : String ,
     val kcal : String ,
     val imageUrl : String
){
    constructor() : this(0 , "" , "" , "" , "" , "" , "")
}
