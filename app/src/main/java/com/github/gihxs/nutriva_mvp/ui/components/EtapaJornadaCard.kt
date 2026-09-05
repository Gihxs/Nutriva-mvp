package com.github.gihxs.nutriva_mvp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.gihxs.nutriva_mvp.model.EtapaJornada
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTeal
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTextSecondary

@Composable
fun EtapaJornadaCard(etapa: EtapaJornada, onIniciarTriagem: (() -> Unit)? = null, onEncontrarPostos: (() -> Unit)? = null) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Text("0${etapa.numero}", color = NutrivaTeal, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text(etapa.titulo, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text(etapa.descricao, color = NutrivaTextSecondary)

            if (etapa.possuiBotaoTriagem && onIniciarTriagem != null) {
                Spacer(Modifier.height(12.dp))
                PrimaryButton("Iniciar triagem", onClick = onIniciarTriagem)
            }
            if (etapa.numero == 2 && onEncontrarPostos != null) {
                Spacer(Modifier.height(12.dp))
                PrimaryButton("Encontrar postos", onClick = onEncontrarPostos)
            }
        }
    }
}
