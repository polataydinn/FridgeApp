package com.ayse.fridgeapp.data.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayse.fridgeapp.data.model.Foods

interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoods(foods: Foods)

    @Query("Select * From foods")
    fun getFoods(): List<Foods>
}