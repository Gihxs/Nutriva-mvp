package com.github.gihxs.nutriva_mvp.model 

data class EtapaJornada(
    val numero: Int,
    val titulo: String,
    val descricao: String,
    val possuiBotaoTriagem: Boolean = false
)