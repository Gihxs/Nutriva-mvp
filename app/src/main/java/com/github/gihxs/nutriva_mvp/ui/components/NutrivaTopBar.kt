package com.github.gihxs.nutriva_mvp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaBackground
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaCardBackground
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaDarkBlue

@Composable
fun NutrivaTopBar(navController: NavHostController, titulo: String? = null) {
    Column(modifier = Modifier.fillMaxWidth()) {

        // Faixa de marca — aparece em TODAS as telas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(NutrivaCardBackground)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(NutrivaDarkBlue),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.WaterDrop,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(Modifier.width(8.dp))
            Text("Nutriva", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = NutrivaDarkBlue)
        }

        // Faixa de navegação — só aparece fora da Home
        if (titulo != null) {
            HorizontalDivider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(NutrivaBackground)
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val podeVoltar = navController.previousBackStackEntry != null
                if (podeVoltar) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
                Text(
                    titulo,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = if (podeVoltar) 0.dp else 16.dp)
                )
                IconButton(onClick = {
                    navController.navigate(NutrivaScreen.Home.route) {
                        popUpTo(NutrivaScreen.Home.route) { inclusive = true }
                    }
                }) {
                    Icon(Icons.Filled.Home, contentDescription = "Início")
                }
            }
        }
    }
}
