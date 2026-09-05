package com.github.gihxs.nutriva_mvp.ui.screens.duvidas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar


@Composable
fun DuvidasScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            NutrivaTopBar(
                navController = navController,
                titulo = "Entre em contato"
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
        ) {
            Text(
                "Estamos aqui para ajudar!",
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(8.dp))

            Text(
                "Precisa de ajuda ou quer saber mais sobre a doação de leite materno? Entre em contato com nossa equipe pelos canais abaixo."
            )

            Spacer(Modifier.height(24.dp))

            Text("E-mail: contato@nutriva.com.br")
            Text("Telefone: (11) 11111-1111")
        }
    }
}