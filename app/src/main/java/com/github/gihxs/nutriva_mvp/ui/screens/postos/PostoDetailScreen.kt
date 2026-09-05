package com.github.gihxs.nutriva_mvp.ui.screens.postos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.ui.components.PrimaryButton
import com.github.gihxs.nutriva_mvp.viewmodel.PostosViewModel

@Composable
fun PostoDetailScreen(postoId: Int, navController: NavHostController, viewModel: PostosViewModel = viewModel()) {
    val posto = viewModel.buscarPorId(postoId)
    var mostrarConfirmacao by remember { mutableStateOf(false) }

    Scaffold(topBar = { NutrivaTopBar(navController = navController, titulo = "Detalhes do posto") }) { padding ->
        Column(Modifier.padding(padding).padding(24.dp)) {
            if (posto == null) {
                Text("Posto não encontrado.")
            } else {
                Text(posto.nome, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Text(posto.tipo)
                Spacer(Modifier.height(16.dp))
                Text("Endereço: ${posto.endereco}")
                Text("Horário: ${posto.horario}")
                Text("Distância: ${posto.distanciaKm} km")
                Spacer(Modifier.height(32.dp))
                PrimaryButton(texto = "Confirmar agendamento neste posto",
                    onClick =  {
                    mostrarConfirmacao = true
                 }
                )
            }
        }
    }

    if (mostrarConfirmacao && posto != null) {
        AlertDialog(
            onDismissRequest = { mostrarConfirmacao = false },
            title = { Text("Agendamento confirmado!") },
            text = {
                Text("Sua doação foi agendada em ${posto.nome}. Compareça no horário de funcionamento (${posto.horario}) com o leite já higienizado.")
            },
            confirmButton = {
                TextButton(onClick = {
                    mostrarConfirmacao = false
                    navController.navigate(NutrivaScreen.Home.route) {
                        popUpTo(NutrivaScreen.Home.route) { inclusive = true }
                    }
                }) {
                    Text("Voltar para o início")
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrarConfirmacao = false }) {
                    Text("Fechar")
                }
            }
        )
    }
}