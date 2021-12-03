package com.example.weekmenu.feature.recipes.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weekmenu.repository.AppRepository

class RecipesViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getRecipes() = appRepository.recipes
}