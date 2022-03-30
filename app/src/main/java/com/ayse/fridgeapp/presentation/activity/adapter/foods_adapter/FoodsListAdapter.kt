package com.ayse.fridgeapp.presentation.activity.adapter.foods_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ayse.fridgeapp.data.model.Foods
import org.tensorflow.lite.examples.detection.databinding.RowFoodItemBinding
import java.util.*

class FoodsListAdapter : ListAdapter<Foods, FoodsListViewHolder>(FoodsListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsListViewHolder {
        val binding = RowFoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class FoodsListViewHolder(private val binding: RowFoodItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(food: Foods?) {
        var itemsString = ""
        food?.let {
            it.listOfFoods.forEach { foodItem ->
                itemsString = itemsString + " " + foodItem.foodName + ","
            }
            itemsString = itemsString.dropLast(0).drop(0)
            val date = Date(food.createDate)
            val dateInString = date.day.toString() + " " + date.month + " " + date.year
            val timeHour = date.hours.toString()
            val timeMinutes = date.minutes.toString()
            binding.apply {
                cardItemsText.text = itemsString
                cardDateText.text = dateInString
                cardTimeHour.text = timeHour
                cardTimeMinutes.text = timeMinutes
            }
        }
    }

}

class FoodsListDiffUtil : DiffUtil.ItemCallback<Foods>() {
    override fun areItemsTheSame(oldItem: Foods, newItem: Foods): Boolean {
        return oldItem.createDate == newItem.createDate
    }

    override fun areContentsTheSame(oldItem: Foods, newItem: Foods): Boolean {
        return oldItem == newItem
    }

}
