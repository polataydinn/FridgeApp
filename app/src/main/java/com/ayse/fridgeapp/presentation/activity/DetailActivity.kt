package com.ayse.fridgeapp.presentation.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ayse.fridgeapp.R
import com.ayse.fridgeapp.data.model.Food
import com.ayse.fridgeapp.data.model.Foods
import com.ayse.fridgeapp.presentation.activity.adapter.food_adapter.FoodDetailAdapter

class DetailActivity : AppCompatActivity() {
    private lateinit var detailAdapter: FoodDetailAdapter
    private lateinit var finishedItemsAdapter: FoodDetailAdapter
    private var mFoodList: MutableList<Food> = mutableListOf()
    private var mOldFoodList: MutableList<Food> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        detailAdapter = FoodDetailAdapter()
        finishedItemsAdapter = FoodDetailAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.detail_recyclerView)
        val finishedRecyclerView = findViewById<RecyclerView>(R.id.finished_items_recyclerView)
        val finishedItemsText = findViewById<TextView>(R.id.finished_items_text)

        recyclerView.adapter = detailAdapter
        finishedRecyclerView.adapter = finishedItemsAdapter

        val food = intent.extras?.getParcelable<Foods>("food_detail")
        food?.listOfFoods?.reversed()?.forEach {
            mFoodList.add(it)
        }
        val oldFood = intent.extras?.getParcelable<Foods>("food_detail_old")

        detailAdapter.submitList(food?.listOfFoods)
        if (oldFood != null) {
            val differenceList =
                food?.listOfFoods?.map { mFood -> oldFood.listOfFoods.filter { mFood.foodName != it.foodName } }
                    ?.distinct()
            try {
                differenceList?.get(1)?.forEach {
                    mOldFoodList.add(Food(it.foodName, 0, 0))
                }
            }catch (e: Exception){
                differenceList?.get(0)?.forEach {
                    mOldFoodList.add(Food(it.foodName, 0, 0))
                }
            }


            if (mOldFoodList.size == 0){
                finishedItemsText.visibility = View.INVISIBLE
            }

            finishedItemsAdapter.submitList(mOldFoodList)

            food?.listOfFoods?.forEachIndexed { index, mFood ->
                oldFood.listOfFoods.forEach { oldFood ->
                    if (mFood.foodName == oldFood.foodName) {
                        mFoodList[index].difference = mFood.amount - oldFood.amount
                    }
                }
            }
            detailAdapter.submitList(mFoodList)
        }else {
            finishedItemsText.visibility = View.INVISIBLE
        }
    }
}