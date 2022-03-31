package com.ayse.fridgeapp.presentation.activity

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.ayse.fridgeapp.R
import com.ayse.fridgeapp.data.model.Foods
import com.ayse.fridgeapp.presentation.activity.adapter.food_adapter.FoodDetailAdapter

class DetailActivity : AppCompatActivity() {
    private lateinit var detailAdapter: FoodDetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        detailAdapter = FoodDetailAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.detail_recyclerView)
        recyclerView.adapter = detailAdapter
        val food = intent.extras?.getParcelable<Foods>("food_detail")
        detailAdapter.submitList(food?.listOfFoods)

    }
}