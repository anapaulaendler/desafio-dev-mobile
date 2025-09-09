package com.anapaulaendler.user_screens.view.screens

import com.anapaulaendler.user_screens.model.User
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    user: User,
    onToggleTheme: () -> Unit,
    onGreetingChange: (String) -> Unit,
    onBack: () -> Unit
) {
    var greeting by remember { mutableStateOf(user.greeting) }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Configuracoes")
        Spacer(Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Tema escuro")
            Spacer(Modifier.width(8.dp))
            Switch(checked = user.prefersDarkTheme, onCheckedChange = { onToggleTheme() })
        }
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = greeting,
            onValueChange = { greeting = it },
            label = { Text("Saudacao") }
        )
        Spacer(Modifier.height(12.dp))
        Row {
            Button(onClick = {
                onGreetingChange(greeting.trim().ifBlank { "Oi" })
                onBack()
            }) {
                Text("Salvar")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = onBack) {
                Text("Voltar")
            }
        }
    }
}
