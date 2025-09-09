package com.anapaulaendler.user_screens.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anapaulaendler.user_screens.model.User

@Composable
fun WelcomeScreen(
    user: User,
    onSettings: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("${user.greeting}, ${user.name}!")
        Spacer(Modifier.height(12.dp))
        Button(onClick = onSettings) {
            Text("Configuracoes")
        }
    }
}
