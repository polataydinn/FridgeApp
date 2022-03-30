package com.ayse.fridgeapp.data.repository

import com.ayse.fridgeapp.data.model.Foods
import com.ayse.fridgeapp.data.room.FoodDao

class Repository(private val foodDao: FoodDao) {
    val getAllFoods = foodDao.getFoods()

    suspend fun insertFoods(foods: Foods){
        foodDao.insertFoods(foods)
    }
}