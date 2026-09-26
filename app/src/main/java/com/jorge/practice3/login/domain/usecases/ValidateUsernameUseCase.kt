package com.jorge.practice3.login.domain.usecases

class ValidateUsernameUseCase {

    operator fun invoke(username: String): Boolean {
        return username.length >= 3
    }

}