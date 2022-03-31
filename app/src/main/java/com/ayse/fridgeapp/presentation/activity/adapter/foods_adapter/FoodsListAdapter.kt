package com.ayse.fridgeapp.presentation.activity.adapter.foods_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ayse.fridgeapp.constants.Constants
import com.ayse.fridgeapp.data.model.Food
import com.ayse.fridgeapp.data.model.Foods
import org.tensorflow.lite.examples.detection.databinding.RowFoodItemBinding
import java.util.*

class FoodsListAdapter : ListAdapter<Foods, FoodsListViewHolder>(FoodsListDiffUtil()) {

    var onItemClick: ((Foods) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsListViewHolder {
        val binding = RowFoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodsListViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }
}

class FoodsListViewHolder(private val binding: RowFoodItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(food: Foods?, onItemClick: ((Foods) -> Unit)?) {
        var itemsString = ""
        food?.let {
            it.listOfFoods.forEach { foodItem ->
                itemsString = itemsString + " " + foodItem.foodName + ","
            }
            itemsString = itemsString.dropLast(1).drop(1)
            val date = Date(food.createDate)
            val dateInString =
                date.date.toString() + " " + Constants.MONTHS_HASHMAP[date.month + 1] + " " + (date.year + 1900)
            val timeHour = date.hours.toString()
            val timeMinutes = date.minutes.toString()
            binding.apply {
                cardItemsText.text = itemsString
                cardDateText.text = dateInString
                cardTimeHour.text = timeHour
                cardTimeMinutes.text = timeMinutes
            }
            binding.root.setOnClickListener {
                onItemClick?.invoke(food)
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
