package com.anapaulaendler.user_screens.model

data class User(
    val name: String = "",
    val prefersDarkTheme: Boolean = false,
    val greeting: String = "Oi"
)