package com.example.itrueque.ui.view.login

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {

    }

    fun loadData() {

    }

    fun login() {

        // Initialize Firebase Auth
        var auth: FirebaseAuth = Firebase.auth

        val currentUser = auth.currentUser
        Log.d("currentUser", currentUser?.email ?: "No hay usuario")
        if(currentUser != null){
            Log.d("currentUser", "logeado")

        } else {
            Log.d("currentUser", "no logeado")

        }

        auth.signInWithEmailAndPassword("samu6333@gmail.com", "Samu_bauty9")
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("loginResponse", "signInWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("loginResponse", "signInWithEmail:failure", task.exception)
                }
            }

    }
}