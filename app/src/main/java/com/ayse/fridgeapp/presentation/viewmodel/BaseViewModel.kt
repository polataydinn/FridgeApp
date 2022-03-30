package com.ayse.fridgeapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ayse.fridgeapp.data.model.Foods
import com.ayse.fridgeapp.data.repository.Repository
import com.ayse.fridgeapp.data.room.FoodDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel(application: Application): AndroidViewModel(application) {
    private val foodDao = FoodDatabase.getDatabase(application).foodDao()
    private val repository = Repository(foodDao)
    val getFoods = repository.getAllFoods

    fun insertFood(foods: Foods){
        viewModelScope.launch (Dispatchers.IO){
            repository.insertFoods(foods)
        }
    }
}