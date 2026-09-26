package com.jorge.practice3.login.domain.usecases

class ValidatePasswordUseCase {

    operator fun invoke(password: String): Boolean {
        return password.length >= 6
    }

}