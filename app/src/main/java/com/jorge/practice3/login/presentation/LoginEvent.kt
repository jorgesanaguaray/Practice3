package com.jorge.practice3.login.presentation

sealed interface LoginEvent {

    data class ChangeUsername(val username: String) : LoginEvent
    data class ChangePassword(val password: String) : LoginEvent
    data object Login : LoginEvent

}