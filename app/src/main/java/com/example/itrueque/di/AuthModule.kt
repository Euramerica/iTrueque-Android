package com.example.itrueque.di

import com.example.itrueque.data.repository.AuthRepositoryImpl
import com.example.itrueque.domain.repository.AuthRepository
import com.example.itrueque.domain.usecase.LoginUseCase
import com.example.itrueque.domain.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class AuthModule {

    @Provides
    fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository {
        return repository
    }

    @Provides
    @Named("login")
    fun provideAuthUseCase(useCase: LoginUseCase): LoginUseCase {
        return useCase
    }

    @Provides
    @Named("signUp")
    fun provideSignUpCase(useCase: SignUpUseCase): SignUpUseCase {
        return useCase
    }
}
