package com.jorge.practice3.login.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jorge.practice3.login.presentation.LoginEvent
import com.jorge.practice3.login.presentation.LoginState

@Composable
fun LoginForm(
    modifier: Modifier,
    state: LoginState,
    onEvent: (LoginEvent) -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = state.username, onValueChange = { onEvent(LoginEvent.ChangeUsername(it))} )
        if (state.usernameError != null) Text(text = state.usernameError)
        TextField(value = state.password, onValueChange = { onEvent(LoginEvent.ChangePassword(it))} )
        if (state.passwordError != null) Text(text = state.passwordError)
        Button(onClick = { onEvent(LoginEvent.Login) }) {
            Text(text = "Login")
        }
    }

}