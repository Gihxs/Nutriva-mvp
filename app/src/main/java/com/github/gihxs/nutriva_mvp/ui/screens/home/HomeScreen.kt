package com.github.gihxs.nutriva_mvp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.HomeMenuButton
import com.github.gihxs.nutriva_mvp.ui.components.LiveStatCard
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTextSecondary
import com.github.gihxs.nutriva_mvp.R

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { NutrivaTopBar(navController = navController) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            LiveStatCard(valor = "+12.430")

            Spacer(Modifier.height(32.dp))

            Text(
                "Cada doação conta!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            Text(
                "Conectamos nutrizes a postos de coleta, para que nenhum prematuro fique sem alimento.",
                color = NutrivaTextSecondary
            )

            Spacer(Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                HomeMenuButton(
                    icon = Icons.Filled.Favorite,
                    texto = "Agendar doação",
                    destaque = true,
                    modifier = Modifier.weight(1f)
                ) {
                    navController.navigate(NutrivaScreen.TriagemForm.route)
                }

                HomeMenuButton(
                    icon = Icons.Filled.Place,
                    texto = "Encontrar postos",
                    modifier = Modifier.weight(1f)
                ) {
                    navController.navigate(NutrivaScreen.PostosList.route)
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                HomeMenuButton(
                    icon = Icons.Filled.HelpOutline,
                    texto = "Dúvidas frequentes",
                    modifier = Modifier.weight(1f)
                ) {
                    navController.navigate(NutrivaScreen.Faq.route)
                }

                HomeMenuButton(
                    icon = Icons.Filled.Timeline,
                    texto = "Jornada da Nutriva",
                    modifier = Modifier.weight(1f)
                ) {
                    navController.navigate(NutrivaScreen.Jornada.route)
                }
            }


            Spacer(Modifier.height(28.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.nutriva_mae_bebe),
                    contentDescription = "Mãe amamentando seu bebê",
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}