package com.example.weekmenu.feature.recipes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.R
import com.example.weekmenu.feature.recipes.data.Recipe

class RecipesAdapter(val chooseRecipe: RecipeOnClickListener) :
    RecyclerView.Adapter<RecipesViewHolder>() {

    private var recipes = listOf<Recipe>()

    fun setItem(recipes: List<Recipe>) {
        this.recipes = recipes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipesViewHolder(view, chooseRecipe)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size
}