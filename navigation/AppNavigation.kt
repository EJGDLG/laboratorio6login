package com.example.laboratorio6login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio6login.screens.Galeria
import com.example.laboratorio6login.screens.login


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.login.route) {
        composable(AppScreens.login.route) {
            login(navController)
        }
        composable(AppScreens.Galeria.route) {
            Galeria(navController)
        }
    }
}


