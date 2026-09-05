package com.github.gihxs.nutriva_mvp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.gihxs.nutriva_mvp.model.Posto
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTeal
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTextSecondary

@Composable
fun PostoCard(posto: Posto, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        colors = CardDefaults.cardColors()
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(posto.tipo.uppercase(), color = NutrivaTeal, fontWeight = FontWeight.Bold)
                Text("${posto.distanciaKm} km", fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(4.dp))
            Text(posto.nome, fontWeight = FontWeight.Bold)
            Text(posto.endereco, color = NutrivaTextSecondary)
            Text(posto.horario, color = NutrivaTextSecondary)
        }
    }
}
