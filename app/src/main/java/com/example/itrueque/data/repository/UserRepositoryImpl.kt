package com.example.itrueque.data.repository

import com.example.itrueque.data.network.UserDataSource
import com.example.itrueque.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
) : UserRepository {

}