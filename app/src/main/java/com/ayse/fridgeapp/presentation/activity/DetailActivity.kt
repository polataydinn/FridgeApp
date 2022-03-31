package com.ayse.fridgeapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.ayse.fridgeapp.data.model.Foods
import com.ayse.fridgeapp.presentation.activity.adapter.food_adapter.FoodDetailAdapter
import org.tensorflow.lite.examples.detection.R

class DetailActivity : AppCompatActivity() {
    private lateinit var detailAdapter: FoodDetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detailAdapter = FoodDetailAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.detail_recyclerView)
        recyclerView.adapter = detailAdapter
        val food = intent.extras?.getParcelable<Foods>("food_detail")
        detailAdapter.submitList(food?.listOfFoods)

    }
}