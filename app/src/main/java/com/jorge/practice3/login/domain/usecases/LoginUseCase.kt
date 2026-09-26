package com.jorge.practice3.login.domain.usecases

import com.jorge.practice3.login.domain.repositories.LoginRepository

class LoginUseCase(
    private val repository: LoginRepository
) {

    suspend operator fun invoke(username: String, password: String) {
        repository.login(username, password)
    }

}