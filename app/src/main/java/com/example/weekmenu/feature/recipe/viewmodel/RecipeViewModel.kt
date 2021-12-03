package com.example.weekmenu.feature.recipe.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weekmenu.repository.AppRepository

class RecipeViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getRecipe(id: Long = 0) = appRepository.recipes[id.toInt()]
}