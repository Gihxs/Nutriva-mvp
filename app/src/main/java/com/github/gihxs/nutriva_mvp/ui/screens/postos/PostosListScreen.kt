package com.github.gihxs.nutriva_mvp.ui.screens.postos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.ui.components.PostoCard
import com.github.gihxs.nutriva_mvp.viewmodel.PostosViewModel

@Composable
fun PostosListScreen(navController: NavHostController, viewModel: PostosViewModel = viewModel()) {
    val postos by viewModel.postos.collectAsState()
    val busca by viewModel.busca.collectAsState()

    Scaffold(
        topBar = { NutrivaTopBar(navController = navController, titulo = "Encontre onde doar") }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = busca,
                onValueChange = { viewModel.buscarPorNomeOuCep(it) },
                label = { Text("Digite seu CEP ou nome do posto") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(postos) { posto ->
                    PostoCard(posto = posto) {
                        navController.navigate(NutrivaScreen.PostoDetail.createRoute(posto.id))
                    }
                }
            }
        }
    }
}
