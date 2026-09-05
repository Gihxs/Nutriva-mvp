package com.github.gihxs.nutriva_mvp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaCardBackground
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaDarkBlue
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTeal

@Composable
fun HomeMenuButton(
    icon: ImageVector,
    texto: String,
    destaque: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .aspectRatio(1.3f)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (destaque) NutrivaDarkBlue else NutrivaCardBackground
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = if (destaque) Color.White else NutrivaTeal
            )
            Spacer(Modifier.height(8.dp))
            Text(
                texto,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if (destaque) Color.White else NutrivaDarkBlue
            )
        }
    }
}
