package com.example.itrueque.di

import com.example.itrueque.data.repository.AuthRepositoryImpl
import com.example.itrueque.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AuthModule {

    @Provides
    fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository {
        return repository
    }
}
