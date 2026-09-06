package com.github.gihxs.nutriva_mvp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.R
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.HomeMenuButton
import com.github.gihxs.nutriva_mvp.ui.components.LiveStatCard
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaCardBackground
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTeal
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTextSecondary

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

            Spacer(Modifier.height(20.dp))

            LiveStatCard(valor = "+12.430")

            Spacer(Modifier.height(28.dp))

            Text(
                "COMECE POR AQUI",
                color = NutrivaTextSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )

            Spacer(Modifier.height(12.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(NutrivaScreen.TriagemForm.route)
                    },
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = NutrivaCardBackground
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Assignment,
                        contentDescription = null,
                        tint = NutrivaTeal
                    )

                    Spacer(Modifier.width(16.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            "Começar minha triagem",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(4.dp))

                        Text(
                            "Verifique se você pode doar e siga para o próximo passo.",
                            color = NutrivaTextSecondary,
                            fontSize = 14.sp
                        )
                    }

                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = null,
                        tint = NutrivaTeal
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                HomeMenuButton(
                    icon = Icons.Filled.Place,
                    texto = "Encontrar postos",
                    modifier = Modifier.weight(1f)
                ) {
                    navController.navigate(NutrivaScreen.PostosList.route)
                }

                HomeMenuButton(
                    icon = Icons.Filled.Timeline,
                    texto = "Jornada da Nutriva",
                    modifier = Modifier.weight(1f)
                ) {
                    navController.navigate(NutrivaScreen.Jornada.route)
                }
            }

            Spacer(Modifier.height(12.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(NutrivaScreen.Faq.route)
                    },
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = NutrivaCardBackground
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.HelpOutline,
                        contentDescription = null,
                        tint = NutrivaTeal
                    )

                    Spacer(Modifier.width(12.dp))

                    Text(
                        "Dúvidas frequentes",
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = null,
                        tint = NutrivaTextSecondary
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.nutriva_mae_bebe),
                    contentDescription = "Mãe amamentando seu bebê",
                    modifier = Modifier.size(180.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}