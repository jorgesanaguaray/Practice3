package com.jorge.practice3.login.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorge.practice3.login.domain.usecases.LoginUseCase
import com.jorge.practice3.login.domain.usecases.ValidatePasswordUseCase
import com.jorge.practice3.login.domain.usecases.ValidateUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateUsernameUseCase: ValidateUsernameUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val loginUseCase: LoginUseCase
): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {

        when (event) {

            is LoginEvent.ChangeUsername -> {
                state = state.copy(username = event.username)
            }

            is LoginEvent.ChangePassword -> {
                state = state.copy(password = event.password)
            }

            is LoginEvent.Login -> {
                validate()
            }

        }

    }

    private fun validate() {

        val usernameResult = validateUsernameUseCase(state.username)
        val passwordResult = validatePasswordUseCase(state.password)

        if (!usernameResult) {
            state = state.copy(usernameError = "El nombre de usuario debe tener al menos 3 caracteres")
        } else {
            state = state.copy(usernameError = null)
        }
        if (!passwordResult) {
            state = state.copy(passwordError = "La contraseña debe tener al menos 6 caracteres")
        } else {
            state = state.copy(passwordError = null)
        }

        if (usernameResult && passwordResult) {
            state = state.copy(usernameError = null, passwordError = null)
            login()
        }


    }

    private fun login() {

        viewModelScope.launch {
            loginUseCase(state.username, state.password)
        }

    }

}