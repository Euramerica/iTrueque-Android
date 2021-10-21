package com.example.itrueque.data.repository

import com.example.itrueque.data.network.AuthDataSource
import com.example.itrueque.domain.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class AuthRepositoryImpl
@Inject constructor(
    private val authDataSource: AuthDataSource,
) : AuthRepository {

    override fun hasNeedLogin(): Boolean {
        return authDataSource.getCurrentUser() == null
    }

    override suspend fun login(email: String, password: String): Task<AuthResult> {
        return authDataSource.login(email = email, password = password)
    }

    override suspend fun signUp(email: String, password: String): Task<AuthResult> {
        return authDataSource.signUp(email = email, password = password)
    }
}