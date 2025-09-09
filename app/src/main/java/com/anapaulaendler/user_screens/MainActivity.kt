package com.anapaulaendler.user_screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.anapaulaendler.user_screens.ui.AppNavHost
import com.anapaulaendler.user_screens.ui.theme.AppTheme
import com.anapaulaendler.user_screens.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    private val _userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDark = _userViewModel.user.prefersDarkTheme
            AppTheme(darkTheme = isDark) {
                val navController = rememberNavController()
                AppNavHost(navController = navController, viewModel = _userViewModel)
            }
        }
    }
}
