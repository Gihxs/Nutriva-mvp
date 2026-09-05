package com.github.gihxs.nutriva_mvp.model 

data class Posto(
    val id: Int,
    val nome: String,
    val tipo: String,
    val endereco: String,
    val horario: String,
    val distanciaKm: Double
)