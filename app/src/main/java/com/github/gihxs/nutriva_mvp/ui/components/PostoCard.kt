package com.github.gihxs.nutriva_mvp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.gihxs.nutriva_mvp.model.Posto
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaDarkBlue
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTeal
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTealLight
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    posto.tipo.uppercase(),
                    color = NutrivaTeal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Surface(color = NutrivaTealLight, shape = RoundedCornerShape(50)) {
                    Text(
                        "${posto.distanciaKm} km",
                        color = NutrivaTeal,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(Modifier.height(6.dp))
            Text(posto.nome, fontWeight = FontWeight.Bold, fontSize = 17.sp)

            Spacer(Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.LocationOn, contentDescription = null, tint = NutrivaTextSecondary, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(4.dp))
                Text(posto.endereco, color = NutrivaTextSecondary, fontSize = 13.sp)
            }
            Spacer(Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.AccessTime, contentDescription = null, tint = NutrivaTextSecondary, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(4.dp))
                Text(posto.horario, color = NutrivaTextSecondary, fontSize = 13.sp)
            }

            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Ver detalhes", color = NutrivaDarkBlue, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                Spacer(Modifier.width(4.dp))
                Icon(Icons.Filled.ArrowForward, contentDescription = null, tint = NutrivaDarkBlue, modifier = Modifier.size(14.dp))
            }
        }
    }
}