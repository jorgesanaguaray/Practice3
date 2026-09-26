package com.jorge.practice3.navigation

sealed class NavigationRoute(val route: String) {

    data object Login : NavigationRoute("login")
    data object Register : NavigationRoute("register")
    data object Home : NavigationRoute("home")

}