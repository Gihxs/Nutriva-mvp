package com.github.gihxs.nutriva_mvp.ui.screens.faq

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.gihxs.nutriva_mvp.data.FaqMock
import com.github.gihxs.nutriva_mvp.ui.components.FaqCard
import com.github.gihxs.nutriva_mvp.ui.components.NutrivaTopBar

@Composable
fun FaqScreen(navController: NavHostController) {
    Scaffold(topBar = { NutrivaTopBar(navController = navController, titulo = "Dúvidas frequentes") }) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(FaqMock.lista) { item -> FaqCard(item) }
        }
    }
}
