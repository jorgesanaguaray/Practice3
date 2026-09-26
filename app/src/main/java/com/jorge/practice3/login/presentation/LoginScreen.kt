package com.jorge.practice3.login.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.jorge.practice3.login.presentation.components.LoginForm

@Composable
fun LoginScreen(
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val state = viewModel.state

    LoginForm(
        modifier = modifier,
        state = state,
        onEvent = viewModel::onEvent
    )

}