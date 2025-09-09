package com.anapaulaendler.user_screens.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    initialName: String = "",
    onLogin: (String) -> Unit
) {
    var name by remember { mutableStateOf(initialName) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login")
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Seu nome") },
            singleLine = true
        )
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { onLogin(name.trim()) },
            enabled = name.isNotBlank()
        ) {
            Text("Entrar")
        }
    }
}