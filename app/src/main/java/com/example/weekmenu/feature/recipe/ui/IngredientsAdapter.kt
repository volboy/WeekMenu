package com.example.weekmenu.feature.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.R
import com.example.weekmenu.feature.recipe.data.Ingredient

class IngredientsAdapter : RecyclerView.Adapter<IngredientsViewHolder>() {

    private var ingredientsList = emptyList<Ingredient>()

    fun setItems(items: List<Ingredient>) {
        ingredientsList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
        return IngredientsViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.bind(ingredientsList[position])
    }

    override fun getItemCount(): Int = ingredientsList.size
}