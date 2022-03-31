package com.ayse.fridgeapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Entity(tableName = "foods")
@Parcelize
data class Foods (
    val listOfFoods: @RawValue List<Food>,
    @PrimaryKey
    val createDate: String
) : Parcelable