package com.github.gihxs.nutriva_mvp.ui.screens.triagem

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.ui.components.PrimaryButton
import com.github.gihxs.nutriva_mvp.model.ResultadoTriagem
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.ui.components.SecondaryButton
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaError
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaSuccess

@Composable
fun TriagemResultadoScreen(resultado: String, navController: NavHostController) {
    val status = ResultadoTriagem.valueOf(resultado)

    Scaffold(topBar = { NutrivaTopBar(navController = navController, titulo = "Resultado da triagem") }) { padding ->
        Column(
            Modifier.padding(padding).padding(24.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            when (status) {
                ResultadoTriagem.ELEGIVEL -> {
                    Text("Você está apta a doar!", color = NutrivaSuccess, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    Text("Procure um posto de coleta para agendar sua doação.")
                    Spacer(Modifier.height(32.dp))
                    PrimaryButton(texto = "Encontrar postos",
                        onClick = {
                        navController.navigate(NutrivaScreen.PostosList.route)
                     }
                    )
                }
                ResultadoTriagem.NAO_ELEGIVEL -> {
                    Text(
                        "No momento você não se enquadra nos critérios de doação.",
                        color = NutrivaError, fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("Consulte nossa central de dúvidas para entender melhor os critérios.")
                    Spacer(Modifier.height(32.dp))
                    PrimaryButton(texto =  "Ver dúvidas frequentes",
                        onClick = {
                        navController.navigate(NutrivaScreen.Faq.route)
                     }
                    )
                }
                ResultadoTriagem.PENDENTE -> {
                    Text("Responda todas as perguntas para ver o resultado.")
                }
            }

            Spacer(Modifier.height(12.dp))
            SecondaryButton(texto =  "Voltar para o início",
                onClick = {
                navController.navigate(NutrivaScreen.Home.route)
                {
                    popUpTo(NutrivaScreen.Home.route) { inclusive = true }
                }
             }
            )
        }
    }
}
