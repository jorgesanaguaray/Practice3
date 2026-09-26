package com.jorge.practice3.login.presentation

data class LoginState(

    val username: String = "",
    val usernameError: String? = null,
    val password: String = "",
    val passwordError: String? = null

)