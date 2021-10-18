package com.example.itrueque.domain.usecase

import com.example.itrueque.domain.repository.AuthRepository
import javax.inject.Inject

class HasNeedLoginUseCase
@Inject constructor(
    private val repository: AuthRepository
) {

    fun execute(): Boolean = repository.hasNeedLogin()
}