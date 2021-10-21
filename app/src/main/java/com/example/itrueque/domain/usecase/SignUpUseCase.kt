package com.example.itrueque.domain.usecase

import com.example.itrueque.domain.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class SignUpUseCase
@Inject constructor(
    private val repository: AuthRepository
) {

    suspend fun execute(email: String, password: String): Task<AuthResult> =
        repository.signUp(email = email, password = password)
}