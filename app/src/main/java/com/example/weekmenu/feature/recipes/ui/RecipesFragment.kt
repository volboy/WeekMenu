package com.example.weekmenu.feature.recipes.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.MainViewModelFactory
import com.example.weekmenu.R
import com.example.weekmenu.feature.recipes.viewmodel.RecipesViewModel
import com.example.weekmenu.repository.AppRepository

class RecipesFragment : Fragment(R.layout.fragment_recipes), RecipeOnClickListener {

    private val viewModelFactory = MainViewModelFactory(AppRepository)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recipesViewModel =
            ViewModelProvider(this, viewModelFactory)[RecipesViewModel::class.java]
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Рецепты"
        val recipeRv = view.findViewById<RecyclerView>(R.id.frgRecipeRv)
        val recipeAdapter = RecipesAdapter(this)
        val layoutManager = LinearLayoutManager(view.context)
        val recipesItemDecoration = RecipesItemDecoration()
        recipeRv.addItemDecoration(recipesItemDecoration)
        recipeRv.layoutManager = layoutManager
        recipeRv.adapter = recipeAdapter
        recipeAdapter.setItem(recipesViewModel.getRecipes())
    }

    override fun chooseRecipe(view: View) {
        findNavController().navigate(R.id.action_recipesFragment_to_recipeFragment)
    }
}