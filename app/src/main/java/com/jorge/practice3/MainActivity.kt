package com.jorge.practice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jorge.practice3.navigation.NavigationHost
import com.jorge.practice3.navigation.NavigationRoute
import com.jorge.practice3.ui.theme.Practice3Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            Practice3Theme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    NavigationHost(
                        modifier = Modifier.padding(innerPadding),
                        startDestination = NavigationRoute.Login.route,
                        navController = navController
                    )

                }

            }

        }

    }

}