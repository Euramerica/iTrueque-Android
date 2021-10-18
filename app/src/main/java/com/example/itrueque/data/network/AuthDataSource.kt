package com.example.itrueque.data.network

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class AuthDataSource
@Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    fun login(email: String, password: String): Task<AuthResult> {
        val user: MutableStateFlow<FirebaseUser?> = MutableStateFlow(null)
        return firebaseAuth.signInWithEmailAndPassword(email, password)
            /*.addOnCompleteListener { task ->
                user.value = if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    task.result?.user
                } else {
                    null
                }
            }
        return user*/
    }

}
