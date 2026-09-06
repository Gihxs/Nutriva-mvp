package com.github.gihxs.nutriva_mvp.ui.screens.postos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.navigation.NutrivaScreen
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar
import com.github.gihxs.nutriva_mvp.ui.components.PrimaryButton
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaDarkBlue
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTeal
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTealLight
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivaTextSecondary
import com.github.gihxs.nutriva_mvp.viewmodel.PostosViewModel

@Composable
fun PostoDetailScreen(postoId: Int, navController: NavHostController, viewModel: PostosViewModel = viewModel()) {
    val posto = viewModel.buscarPorId(postoId)

    Scaffold(topBar = { NutrivaTopBar(navController = navController, titulo = "Detalhes do posto") }) { padding ->
        Column(Modifier.padding(padding).padding(24.dp)) {
            if (posto == null) {
                Text("Posto não encontrado.")
            } else {
                Text(posto.nome, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(color = NutrivaTealLight, shape = RoundedCornerShape(50)) {
                        Text(
                            posto.tipo,
                            color = NutrivaTeal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    Text("${posto.distanciaKm} km", color = NutrivaTextSecondary, fontSize = 13.sp)
                }

                Spacer(Modifier.height(28.dp))

                InfoBloco(icone = Icons.Filled.LocationOn, rotulo = "LOCALIZAÇÃO", valor = posto.endereco)
                Spacer(Modifier.height(20.dp))
                InfoBloco(icone = Icons.Filled.AccessTime, rotulo = "HORÁRIO", valor = posto.horario)
                Spacer(Modifier.height(20.dp))
                InfoBloco(icone = Icons.Filled.Call, rotulo = "TELEFONE", valor = posto.telefone)

                Spacer(Modifier.height(40.dp))
                PrimaryButton(texto = "Agendar neste posto",
                    onClick = {
                    navController.navigate(NutrivaScreen.Agendamento.createRoute(posto.id))
                 }
                )
            }
        }
    }
}

@Composable
private fun InfoBloco(icone: ImageVector, rotulo: String, valor: String) {
    Row(verticalAlignment = Alignment.Top) {
        Icon(icone, contentDescription = null, tint = NutrivaTeal, modifier = Modifier.size(20.dp))
        Spacer(Modifier.width(10.dp))
        Column {
            Text(rotulo, color = NutrivaTextSecondary, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Spacer(Modifier.height(2.dp))
            Text(valor, color = NutrivaDarkBlue, fontSize = 15.sp)
        }
    }
}