package com.example.weekmenu.feature.login.data

import com.example.weekmenu.feature.recipes.data.Recipe

data class User(
    val name: String = "",
    val email: String = "",
    val recipes: Map<String, Recipe> = emptyMap()
)