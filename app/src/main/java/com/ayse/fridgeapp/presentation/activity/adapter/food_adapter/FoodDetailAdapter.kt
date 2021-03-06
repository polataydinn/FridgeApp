package com.ayse.fridgeapp.presentation.activity.adapter.food_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ayse.fridgeapp.R
import com.ayse.fridgeapp.constants.Constants
import com.ayse.fridgeapp.data.model.Food
import com.ayse.fridgeapp.databinding.RowFoodDetailItemBinding


class FoodDetailAdapter : ListAdapter<Food, FoodDetailViewHolder>(FoodDetailDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodDetailViewHolder {
        val binding =
            RowFoodDetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class FoodDetailViewHolder(private val binding: RowFoodDetailItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Food?) {
        item?.let { food ->
            binding.detailFoodName.text = food.foodName
            binding.detailFoodAmount.text = food.amount.toString()
            Constants.FOOD_ICONS_HASHMAP[food.foodName]?.let { imageId ->
                binding.detailImage.setImageResource(
                    imageId
                )
            }

            if (food.amount == 0) {
                binding.detailFoodAmount.text = "-"
            } else {
                if (food.difference > 0) {
                    binding.increaseOrDecreaseText.text = "+" + food.difference
                    binding.increaseOrDecreaseText.visibility = View.VISIBLE

                } else if (food.difference < 0) {
                    binding.increaseOrDecreaseText.visibility = View.VISIBLE
                    binding.increaseOrDecreaseText.text = food.difference.toString()
                    binding.increaseOrDecreaseText.setTextColor(
                        ContextCompat.getColor(
                            binding.increaseOrDecreaseText.context,
                            R.color.red
                        )
                    )
                }
            }
        }
    }

}


class FoodDetailDiffUtil : DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food) =
        oldItem.foodName == newItem.foodName


    override fun areContentsTheSame(oldItem: Food, newItem: Food) =
        oldItem == newItem
}
