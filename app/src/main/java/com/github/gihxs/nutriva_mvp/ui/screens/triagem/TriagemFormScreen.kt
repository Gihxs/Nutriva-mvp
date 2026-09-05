package com.github.gihxs.nutriva_mvp.ui.screens.triagem

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.ui.components.PrimaryButton
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.viewmodel.TriagemViewModel

@Composable
fun TriagemFormScreen(
    navController: NavHostController,
    viewModel: TriagemViewModel = viewModel()
) {
    val respostas by viewModel.respostas.collectAsState()

    Scaffold(topBar = { NutrivaTopBar(navController = navController, titulo = "Triagem online") }) { padding ->
        Column(Modifier.padding(padding).padding(24.dp)) {
            viewModel.perguntas.forEach { pergunta ->
                Text(pergunta.texto)
                Row(Modifier.padding(vertical = 8.dp)) {
                    FilterChip(
                        selected = respostas[pergunta.id] == true,
                        onClick = { viewModel.responder(pergunta.id, true) },
                        label = { Text("Sim") }
                    )
                    Spacer(Modifier.width(8.dp))
                    FilterChip(
                        selected = respostas[pergunta.id] == false,
                        onClick = { viewModel.responder(pergunta.id, false) },
                        label = { Text("Não") }
                    )
                }
                Spacer(Modifier.height(8.dp))
            }

            Spacer(Modifier.height(16.dp))
            PrimaryButton("Ver resultado", onClick = {
                val resultado = viewModel.avaliarElegibilidade()
                navController.navigate(NutrivaScreen.TriagemResultado.createRoute(resultado.name))
            })
        }
    }
}
