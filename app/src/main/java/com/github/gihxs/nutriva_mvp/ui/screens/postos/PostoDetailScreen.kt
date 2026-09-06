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
                Text("Telefone: ${posto.telefone}")
                Text("Horário: ${posto.horario}")
                Text("Distância: ${posto.distanciaKm} km")
                Spacer(Modifier.height(32.dp))
                PrimaryButton(texto = "Agendar neste posto",
                    onClick =  {
                        navController.navigate(
                            NutrivaScreen.Agendamento.createRoute(posto.id)
                        )
                 }
                )
            }
        }
    }
}