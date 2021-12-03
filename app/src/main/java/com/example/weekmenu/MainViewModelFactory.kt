package com.example.weekmenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weekmenu.feature.recipe.viewmodel.RecipeViewModel
import com.example.weekmenu.feature.recipes.viewmodel.RecipesViewModel
import com.example.weekmenu.repository.AppRepository

class MainViewModelFactory(private val appRepository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(RecipeViewModel::class.java) -> RecipeViewModel(
            appRepository
        ) as T
        modelClass.isAssignableFrom(RecipesViewModel::class.java) -> RecipesViewModel(
            appRepository
        ) as T
        else -> throw IllegalAccessException("Uknow ViewModel class")
    }

}