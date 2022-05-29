package com.ayse.fridgeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val foodName: String,
    val amount: Int,
    var difference: Int = 0
): Parcelable
