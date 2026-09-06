package com.github.gihxs.nutriva_mvp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.gihxs.nutriva_mvp.ui.screens.duvidas.DuvidasScreen
import com.github.gihxs.nutriva_mvp.ui.screens.faq.FaqScreen
import com.github.gihxs.nutriva_mvp.ui.screens.home.HomeScreen
import com.github.gihxs.nutriva_mvp.ui.screens.jornada.JornadaScreen
import com.github.gihxs.nutriva_mvp.ui.screens.postos.PostoDetailScreen
import com.github.gihxs.nutriva_mvp.ui.screens.postos.PostosListScreen
import com.github.gihxs.nutriva_mvp.ui.screens.triagem.TriagemFormScreen
import com.github.gihxs.nutriva_mvp.ui.screens.triagem.TriagemResultadoScreen
import com.github.gihxs.nutriva_mvp.ui.screens.agendamento.AgendamentoScreen

@Composable
fun NutrivaNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NutrivaScreen.Home.route) {

        composable(NutrivaScreen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(NutrivaScreen.Jornada.route) {
            JornadaScreen(navController = navController)
        }

        composable(NutrivaScreen.PostosList.route) {
            PostosListScreen(navController = navController)
        }

        composable(
            route = NutrivaScreen.PostoDetail.route,
            arguments = listOf(navArgument("postoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val postoId = backStackEntry.arguments?.getInt("postoId") ?: -1
            PostoDetailScreen(postoId = postoId, navController = navController)
        }

        composable(NutrivaScreen.TriagemForm.route) {
            TriagemFormScreen(navController = navController)
        }

        composable(
            route = NutrivaScreen.TriagemResultado.route,
            arguments = listOf(navArgument("resultado") { type = NavType.StringType })
        ) { backStackEntry ->
            val resultado = backStackEntry.arguments?.getString("resultado") ?: "PENDENTE"
            TriagemResultadoScreen(resultado = resultado, navController = navController)
        }

        composable(NutrivaScreen.Faq.route) {
            FaqScreen(navController = navController)
        }

        composable(NutrivaScreen.Duvidas.route) {
            DuvidasScreen(navController = navController)
        }

        composable(
            route = NutrivaScreen.Agendamento.route,
            arguments = listOf(navArgument("postoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val postoId = backStackEntry.arguments?.getInt("postoId") ?: -1
            AgendamentoScreen(
                postoId = postoId,
                navController = navController
            )
        }
    }
}
