package com.jorge.practice3.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jorge.practice3.login.presentation.LoginScreen

@Composable
fun NavigationHost(
    modifier: Modifier,
    startDestination: String,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(NavigationRoute.Login.route) {
            LoginScreen(modifier = modifier)
        }

        composable(NavigationRoute.Register.route) {
            Text(text = "Register Screen")
        }

        composable(NavigationRoute.Home.route) {
            Text(text = "Home Screen")
        }

    }

}