package com.example.weekmenu.feature.recipes.ui

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.R
import com.example.weekmenu.feature.recipes.data.Recipe

class RecipesViewHolder(view: View, chooseRecipe: RecipeOnClickListener) :
    RecyclerView.ViewHolder(view) {

    private val recipeImg = view.findViewById<AppCompatImageView>(R.id.recipeImg)
    private val recipeTitle = view.findViewById<AppCompatTextView>(R.id.recipeTitle)
    private val recipeSubTile = view.findViewById<AppCompatTextView>(R.id.recipeSubtitle)

    init {
        recipeImg.setOnClickListener { chooseRecipe.chooseRecipe(it) }
    }

    fun bind(item: Recipe) {
        recipeTitle.text = item.title
        recipeSubTile.text = item.subtitle
    }
}