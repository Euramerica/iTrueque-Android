package com.example.itrueque.data.repository

import com.example.itrueque.data.network.AuthDataSource
import com.example.itrueque.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl
@Inject constructor(
    private val authDataSource: AuthDataSource,
) : AuthRepository {

    override fun hasNeedLogin(): Boolean {
        return authDataSource.getCurrentUser() == null
    }
}