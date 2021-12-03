package com.example.weekmenu.repository

import com.example.weekmenu.feature.recipe.data.Ingredient
import com.example.weekmenu.feature.recipes.data.Recipe

object AppRepository {
    val recipes = listOf(
        Recipe(
            id = 0,
            img = "",
            title = "",
            subtitle = "",
            text = "",
            ingredients = listOf(
                Ingredient(
                    id = 0,
                    img = "",
                    product = "",
                    quantity = ""
                )
            )
        )
    )
}