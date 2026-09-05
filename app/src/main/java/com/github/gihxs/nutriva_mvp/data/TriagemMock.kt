package com.github.gihxs.nutriva_mvp.data

import com.github.gihxs.nutriva_mvp.model.PerguntaTriagem

object TriagemMock {
    val perguntas = listOf(
        PerguntaTriagem(1, "Você está amamentando atualmente?"),
        PerguntaTriagem(2, "Você faz uso de medicamentos contraindicados à doação?"),
        PerguntaTriagem(3, "Você realizou os exames pré-natais recomendados?"),
        PerguntaTriagem(4, "Você fuma ou consome bebida alcoólica regularmente?")
    )
}
