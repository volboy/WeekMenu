package com.example.weekmenu.feature.recipe

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.R

class RecipeFragment : Fragment(R.layout.fragment_recipe) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Описание"
        val ingAdapter = IngredientsAdapter()
        val layoutManager = LinearLayoutManager(view.context)
        val ingRv = view.findViewById<RecyclerView>(R.id.frgIngredientRv)
        ingRv.layoutManager = layoutManager
        ingRv.adapter = ingAdapter
        ingRv.addItemDecoration(IngredientsItemDecorator())
        ingAdapter.setItems(ingredients)
    }

    companion object {
        val ingredients = listOf(
            Ingredient(
                id = 0,
                img = "",
                product = "Тыква",
                quantity = "1 кг"
            ),
            Ingredient(
                id = 0,
                img = "",
                product = "Тыква",
                quantity = "1 кг"
            ),
            Ingredient(
                id = 0,
                img = "",
                product = "Тыква",
                quantity = "1 кг"
            ),
            Ingredient(
                id = 0,
                img = "",
                product = "Тыква",
                quantity = "1 кг"
            ),
            Ingredient(
                id = 0,
                img = "",
                product = "Тыква",
                quantity = "1 кг"
            ),
            Ingredient(
                id = 0,
                img = "",
                product = "Тыква",
                quantity = "1 кг"
            ),
        )
    }
}