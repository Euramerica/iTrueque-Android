package com.example.itrueque.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.itrueque.data.network.AuthDataSource
import com.example.itrueque.domain.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
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
}