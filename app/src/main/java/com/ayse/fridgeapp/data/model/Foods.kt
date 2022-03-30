package com.ayse.fridgeapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Foods (
    val listOfFoods: List<Food>,
    @PrimaryKey
    val createDate: String
)