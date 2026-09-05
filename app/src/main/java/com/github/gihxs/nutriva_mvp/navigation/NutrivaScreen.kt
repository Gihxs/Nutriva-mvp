package com.github.gihxs.nutriva_mvp.navigation 

sealed class NutrivaScreen(val route: String) {
    object Home : NutrivaScreen("home")
    object Jornada : NutrivaScreen("jornada")
    object PostosList : NutrivaScreen("postos")
    object PostoDetail : NutrivaScreen("postos/{postoId}") {
        fun createRoute(postoId: Int) = "postos/$postoId"
    }
    object TriagemForm : NutrivaScreen("triagem")
    object TriagemResultado : NutrivaScreen("triagem/resultado/{resultado}") {
        fun createRoute(resultado: String) = "triagem/resultado/$resultado"
    }
    object Faq : NutrivaScreen("faq")
    object Duvidas : NutrivaScreen("duvidas")
}