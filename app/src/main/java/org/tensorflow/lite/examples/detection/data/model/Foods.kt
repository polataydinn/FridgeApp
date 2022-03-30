package org.tensorflow.lite.examples.detection.data.model

import androidx.room.Entity

@Entity(tableName = "foods")
data class Foods (
    val listOfFoods: List<Food>,
    val createDate: String
)