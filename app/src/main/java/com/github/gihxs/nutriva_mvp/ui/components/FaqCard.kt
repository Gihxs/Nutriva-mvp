package com.github.gihxs.nutriva_mvp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.gihxs.nutriva_mvp.model.FaqItem

@Composable
fun FaqCard(item: FaqItem) {
    var expandido by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth().clickable { expandido = !expandido }) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(item.pergunta, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Icon(if (expandido) Icons.Filled.Remove else Icons.Filled.Add, contentDescription = null)
            }
            AnimatedVisibility(visible = expandido) {
                Text(item.resposta, modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}
