package org.tensorflow.lite.examples.detection.data.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.tensorflow.lite.examples.detection.data.model.Food

class TypeConverters {
    @TypeConverter
    fun fromFood(food: List<Food>): String = Gson().toJson(food)

    private val itemType = object : TypeToken<List<Food>>(){}.type
    @TypeConverter
    fun toFood(food: String): List<Food> = Gson().fromJson(food, itemType)
}