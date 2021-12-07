package com.example.weekmenu.feature.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weekmenu.MainActivity
import com.example.weekmenu.R
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btnSingIn: Button
    private lateinit var btnSingUp: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        email = view.findViewById(R.id.loginEmailEt)
        password = view.findViewById(R.id.loginPasswordEt)
        btnSingIn = view.findViewById(R.id.singInBtn)
        btnSingUp = view.findViewById(R.id.singUpBtn)
        mAuth = (requireActivity() as MainActivity).mAuth

        btnSingIn.setOnClickListener {
            singIn(
                email.text.toString(),
                password.text.toString()
            )
        }
        btnSingUp.setOnClickListener {
            createAccount(
                email.text.toString(),
                password.text.toString()
            )
        }
    }

    private fun createAccount(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                requireActivity()
            ) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = mAuth.currentUser
                    findNavController().navigate(R.id.action_loginFragment_to_recipesFragment)
                } else {
                    Log.d(TAG, "createUserWithEmail:failure ${task.exception}")
                }
            }
    }

    private fun singIn(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "singInWithEmail:success")
                    val user = mAuth.currentUser
                    findNavController().navigate(R.id.action_loginFragment_to_recipesFragment)
                } else {
                    Log.d(TAG, "singInWithEmail:failure")
                }
            }
    }

    companion object {
        const val TAG = "TAG"
    }
}