package com.jorge.practice3.login.di

import com.jorge.practice3.login.data.repositories.LoginRepositoryImpl
import com.jorge.practice3.login.domain.repositories.LoginRepository
import com.jorge.practice3.login.domain.usecases.LoginUseCase
import com.jorge.practice3.login.domain.usecases.ValidatePasswordUseCase
import com.jorge.practice3.login.domain.usecases.ValidateUsernameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    @Singleton
    fun provideLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideValidateUsernameUseCase(): ValidateUsernameUseCase {
        return ValidateUsernameUseCase()
    }

    @Provides
    @Singleton
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase {
        return ValidatePasswordUseCase()
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(repository: LoginRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

}