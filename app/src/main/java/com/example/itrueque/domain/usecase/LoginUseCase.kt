package com.example.itrueque.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.itrueque.domain.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class LoginUseCase
@Inject constructor(
    private val repository: AuthRepository
) {

    suspend fun execute(email: String, password: String): Task<AuthResult> =
        repository.login(email = email, password = password)
}