package com.example.weekmenu.feature.recipes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.R

class RecipesFragment : Fragment(R.layout.fragment_recipes), RecipeOnClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Рецепты"
        val recipeRv = view.findViewById<RecyclerView>(R.id.frgRecipeRv)
        val recipeAdapter = RecipesAdapter(this)
        val layoutManager = LinearLayoutManager(view.context)
        val recipesItemDecoration = RecipesItemDecoration()
        recipeRv.addItemDecoration(recipesItemDecoration)
        recipeRv.layoutManager = layoutManager
        recipeRv.adapter = recipeAdapter
        recipeAdapter.setItem(recipes)
    }

    companion object {
        val recipes = listOf(
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            ),
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            ),
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            ),
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            ),
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            ),
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            ),
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            ),
            Recipe(
                id = 0,
                img = "",
                title = "Тыквенный пирог",
                subtitle = "Краткое описание блюда...",
                text = "",
                ingredients = emptyList()
            )
        )
    }

    override fun chooseRecipe(view: View) {
        findNavController().navigate(R.id.action_recipesFragment_to_recipeFragment)
    }
}