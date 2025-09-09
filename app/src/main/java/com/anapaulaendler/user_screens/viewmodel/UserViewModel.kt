package com.anapaulaendler.user_screens.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.anapaulaendler.user_screens.model.User

class UserViewModel : ViewModel() {
    var user by mutableStateOf(User())
        private set

    fun setName(name: String) {
        if (name != user.name) {
            user = user.copy(name = name)
        }
    }

    fun toggleDarkTheme() {
        user = user.copy(prefersDarkTheme = !user.prefersDarkTheme)
    }

    fun setGreeting(greeting: String) {
        user = user.copy(greeting = greeting)
    }
}