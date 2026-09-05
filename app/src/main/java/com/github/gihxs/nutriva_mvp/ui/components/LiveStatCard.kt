package com.github.gihxs.nutriva_mvp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaDarkBlue
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTeal
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTealLight
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTextSecondary

@Composable
fun LiveStatCard(valor: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = NutrivaTealLight)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Favorite, contentDescription = null, tint = NutrivaTeal)
            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text("Doadoras ativas", fontWeight = FontWeight.Bold, color = NutrivaDarkBlue)
                Text("Em tempo real", fontSize = 12.sp, color = NutrivaTextSecondary)
            }
            Text(valor, fontWeight = FontWeight.Bold, color = NutrivaTeal, fontSize = 18.sp)
        }
    }
}
