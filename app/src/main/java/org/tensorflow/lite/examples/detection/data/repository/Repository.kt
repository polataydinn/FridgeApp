package org.tensorflow.lite.examples.detection.data.repository

import org.tensorflow.lite.examples.detection.data.model.Foods
import org.tensorflow.lite.examples.detection.data.room.FoodDao

class Repository(private val foodDao: FoodDao) {
    val getAllFoods = foodDao.getFoods()

    suspend fun insertFoods(foods: Foods){
        foodDao.insertFoods(foods)
    }
}