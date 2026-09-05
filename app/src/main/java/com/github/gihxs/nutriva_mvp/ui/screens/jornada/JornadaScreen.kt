package com.github.gihxs.nutriva_mvp.ui.screens.jornada

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.data.JornadaMock
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.EtapaJornadaCard
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTextSecondary

@Composable
fun JornadaScreen(navController: NavHostController) {
    Scaffold(topBar = { NutrivaTopBar(navController = navController, titulo = "A jornada da doação") }) { padding ->
        Column(Modifier
            .padding(padding)
            .padding(16.dp)) {
            Text("Doação em apenas quatro passos.", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text(
                "Cuidamos da logística, dos protocolos e do calor humano — você cuida de quem mais ama.",
                color = NutrivaTextSecondary
            )
            Spacer(Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(JornadaMock.etapas) { etapa ->
                    EtapaJornadaCard(
                        etapa = etapa,
                        onIniciarTriagem = if (etapa.possuiBotaoTriagem) {
                            { navController.navigate(NutrivaScreen.TriagemForm.route) }
                        } else null,
                        onEncontrarPostos = if (etapa.numero == 2) {
                            {
                                navController.navigate(NutrivaScreen.PostosList.route)
                            }
                        } else null
                    )
                }
            }
        }
    }
}
