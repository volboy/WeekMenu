package com.example.weekmenu.feature.recipes.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekmenu.MainActivity
import com.example.weekmenu.MainViewModelFactory
import com.example.weekmenu.R
import com.example.weekmenu.feature.login.LoginFragment.Companion.TAG
import com.example.weekmenu.feature.login.data.User
import com.example.weekmenu.feature.recipe.data.Ingredient
import com.example.weekmenu.feature.recipes.data.Recipe
import com.example.weekmenu.feature.recipes.viewmodel.RecipesViewModel
import com.example.weekmenu.repository.AppRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class RecipesFragment : Fragment(R.layout.fragment_recipes), RecipeOnClickListener {

    private val viewModelFactory = MainViewModelFactory(AppRepository)
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseRef: DatabaseReference
    private var userId: String? = null
    private lateinit var recipeAdapter: RecipesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recipesViewModel =
            ViewModelProvider(this, viewModelFactory)[RecipesViewModel::class.java]
        (requireActivity() as AppCompatActivity).supportActionBar?.let {
            it.title = "Рецепты"
            it.setDisplayHomeAsUpEnabled(false)
        }
        val recipeRv = view.findViewById<RecyclerView>(R.id.frgRecipeRv)
        val testButton = view.findViewById<Button>(R.id.testButton)
        val mAuth = (requireActivity() as MainActivity).mAuth
        val email = mAuth.currentUser?.email
        val id = mAuth.currentUser?.uid
        userId = id
        testButton.setOnClickListener {
            writeNewUserRecipe()
        }
        val testButton2 = view.findViewById<Button>(R.id.testButton2)
        testButton2.setOnClickListener {
            readRecipes()
        }
        recipeAdapter = RecipesAdapter(this)
        val layoutManager = LinearLayoutManager(view.context)
        val recipesItemDecoration = RecipesItemDecoration()
        recipeRv.addItemDecoration(recipesItemDecoration)
        recipeRv.layoutManager = layoutManager
        recipeRv.adapter = recipeAdapter
        recipeAdapter.setItem(recipesViewModel.getRecipes())
        database =
            Firebase.database("https://weekmenu-96475-default-rtdb.europe-west1.firebasedatabase.app/")
        databaseRef = database.reference

    }

    override fun chooseRecipe(view: View) {
        findNavController().navigate(R.id.action_recipesFragment_to_recipeFragment)
    }

    private fun readRecipes() {
        userId?.let {
            databaseRef.child("users").child(it).get().addOnSuccessListener {
                Log.d(TAG, "Read_Success")
                val user = it.getValue<User>()
                user?.let {
                    recipeAdapter.setItem(user.recipes.values.toList())
                    recipeAdapter.notifyDataSetChanged()
                }
            }.addOnFailureListener {
                Log.d(TAG, "Read_Error")
            }
        }
    }

    private fun writeNewUserRecipe() {
        val key = databaseRef.child("users").push().key
        if (key == null) {
            Log.d(TAG, "key null")
            return
        }

        val recipe = Recipe(
            uid = "$key",
            img = "img",
            title = "title",
            subtitle = "subtitle",
            text = "text",
            ingredients = listOf(
                Ingredient(
                    id = "",
                    product = "",
                    quantity = ""
                ),
                Ingredient(
                    id = "",
                    product = "",
                    quantity = ""
                )

            )

        )
        databaseRef.updateChildren(mapOf("users/$userId/recipes/$key" to recipe))
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Write_Success")
                } else {
                    Log.d(TAG, "Write_Error ${task.exception}")
                }
            }

    }
}