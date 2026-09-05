package com.github.gihxs.nutriva_mvp.model

data class PerguntaTriagem(
    val id: Int,
    val texto: String
)

enum class ResultadoTriagem {
    ELEGIVEL,
    NAO_ELEGIVEL,
    PENDENTE
}
