package com.ayse.fridgeapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.tensorflow.lite.examples.detection.databinding.ActivityBaseBinding

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        baseActivity = this

        binding.addItemFloatingButton.setOnClickListener {
            val intent = Intent(this, DetectorActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        print("breakpoint")
    }


    fun addFood(food: String) {
        listOfFoods.add(food)
    }

}