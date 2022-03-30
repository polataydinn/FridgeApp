package com.ayse.fridgeapp.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ayse.fridgeapp.data.model.Food
import com.ayse.fridgeapp.data.model.Foods
import com.ayse.fridgeapp.presentation.viewmodel.BaseViewModel
import org.tensorflow.lite.examples.detection.databinding.ActivityBaseBinding
import java.util.*

class BaseActivity : AppCompatActivity() {
    companion object {
        @JvmStatic
        private lateinit var baseActivity: BaseActivity

        @JvmStatic
        fun getInstance(): BaseActivity {
            return baseActivity
        }
    }

    private lateinit var binding: ActivityBaseBinding
    private var listOfFoods: MutableList<String> = mutableListOf()
    private val viewModel: BaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        baseActivity = this

        binding.addItemFloatingButton.setOnClickListener {
            val intent = Intent(this, DetectorActivity::class.java)
            startActivity(intent)
        }

        viewModel.getFoods.observe(this) {

        }
    }

    override fun onResume() {
        super.onResume()
        if (listOfFoods.size > 0) {
            val foods = mutableListOf<Food>()
            val tempList = listOfFoods.groupingBy { it }.eachCount()
            tempList.keys.forEach {
                foods.add(Food(it, tempList.getValue(it)))
            }
            viewModel.insertFood(Foods(foods, Calendar.getInstance().time.toString()))
            listOfFoods.clear()
        }
    }


    fun addFood(food: String) {
        listOfFoods.add(food)
    }

}