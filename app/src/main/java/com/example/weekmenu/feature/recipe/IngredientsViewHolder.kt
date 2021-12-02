package com.example.weekmenu.feature.recipe

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.R

class IngredientsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ingredientImage = view.findViewById<AppCompatImageView>(R.id.ingredientImg)
    private val ingredientName = view.findViewById<AppCompatTextView>(R.id.ingredientName)
    private val ingredientQuantity = view.findViewById<AppCompatTextView>(R.id.ingredientQuantity)

    fun bind(item: Ingredient) {
        ingredientName.text = item.product
        ingredientQuantity.text = item.quantity
    }
}