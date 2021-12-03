package com.example.weekmenu.feature.recipes.data

import com.example.weekmenu.feature.recipe.data.Ingredient

data class Recipe(
    val id: Long,
    val img: String,
    val title: String,
    val subtitle: String,
    val text: String,
    val ingredients: List<Ingredient>
)
