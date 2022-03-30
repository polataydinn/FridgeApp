package org.tensorflow.lite.examples.detection.data.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.tensorflow.lite.examples.detection.data.model.Foods

interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoods(foods: Foods)

    @Query("Select * From foods")
    fun getFoods(): List<Foods>
}