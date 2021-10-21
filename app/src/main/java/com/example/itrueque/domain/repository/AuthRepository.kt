package com.example.itrueque.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthRepository {

    fun hasNeedLogin(): Boolean
    suspend fun login(email: String, password: String): Task<AuthResult>
    suspend fun signUp(email: String, password: String): Task<AuthResult>
}