package com.github.gihxs.nutriva_mvp.ui.screens.agendamento

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
fun AgendamentoScreen(postoId: Int, navController: NavHostController, viewModel: PostosViewModel = viewModel()) {
    val posto = viewModel.buscarPorId(postoId)

    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var mostrarConfirmacao by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            NutrivaTopBar(
                navController = navController,
                titulo = "Agendar doação"
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (posto == null) {
                Text("Posto não encontrado.")
            } else {
                Text("Agendando em: ${posto.nome}", fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(24.dp))

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Seu nome completo") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = telefone,
                    onValueChange = { telefone = it },
                    label = { Text("Seu telefone") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(32.dp))

                PrimaryButton(
                    texto = "Confirmar agendamento neste posto",
                    enabled = nome.isNotBlank() && telefone.isNotBlank(),
                    onClick = { mostrarConfirmacao = true }
                )
            }
        }
    }

    if (mostrarConfirmacao && posto != null) {
        AlertDialog(
            onDismissRequest = { mostrarConfirmacao = false },
            title = { Text("Agendamento confirmado!") },
            text = {
                Text("$nome, sua doação foi agendada em ${posto.nome}. Entraremos em contato pelo telefone $telefone. Compareça no horário de funcionamento (${posto.horario}) com o leite já higienizado.")
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