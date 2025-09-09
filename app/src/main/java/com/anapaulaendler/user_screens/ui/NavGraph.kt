package com.anapaulaendler.user_screens.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anapaulaendler.user_screens.view.screens.LoginScreen
import com.anapaulaendler.user_screens.view.screens.SettingsScreen
import com.anapaulaendler.user_screens.view.screens.WelcomeScreen
import com.anapaulaendler.user_screens.viewmodel.UserViewModel

@Composable
fun AppNavHost(navController: NavHostController, viewModel: UserViewModel) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                initialName = viewModel.user.name,
                onLogin = { name ->
                    viewModel.setName(name)
                    navController.navigate("welcome") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("welcome") {
            WelcomeScreen(
                user = viewModel.user,
                onSettings = { navController.navigate("settings") }
            )
        }
        composable("settings") {
            SettingsScreen(
                user = viewModel.user,
                onToggleTheme = { viewModel.toggleDarkTheme() },
                onGreetingChange = { viewModel.setGreeting(it) },
                onBack = { navController.popBackStack() }
            )
        }
    }
}