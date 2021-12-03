package com.example.weekmenu.feature.recipe.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.MainViewModelFactory
import com.example.weekmenu.R
import com.example.weekmenu.feature.recipe.viewmodel.RecipeViewModel
import com.example.weekmenu.repository.AppRepository

class RecipeFragment : Fragment(R.layout.fragment_recipe) {

    private val viewModelFactory = MainViewModelFactory(AppRepository)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recipeViewModel = ViewModelProvider(this, viewModelFactory)[RecipeViewModel::class.java]
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Описание"
        val ingAdapter = IngredientsAdapter()
        val layoutManager = LinearLayoutManager(view.context)
        val ingRv = view.findViewById<RecyclerView>(R.id.frgIngredientRv)
        ingRv.layoutManager = layoutManager
        ingRv.adapter = ingAdapter
        ingRv.addItemDecoration(IngredientsItemDecorator())
        ingAdapter.setItems(recipeViewModel.getRecipe(0).ingredients)
    }
}