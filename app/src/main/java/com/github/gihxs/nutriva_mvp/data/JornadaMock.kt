package com.github.gihxs.nutriva_mvp.data

import com.github.gihxs.nutriva_mvp.model.EtapaJornada

object JornadaMock {
    val etapas = listOf(
        EtapaJornada(
            numero = 1,
            titulo = "Triagem online",
            descricao = "Responda um questionário rápido sobre saúde e medicamentos. Em minutos sabemos se você pode doar.",
            possuiBotaoTriagem = true
        ),
        EtapaJornada(
            numero = 2,
            titulo = "Coleta acolhedora",
            descricao = "Vá ao posto mais próximo ou agende uma coleta. Temos uma equipe preparada para orientar nessa etapa."
        ),
        EtapaJornada(
            numero = 3,
            titulo = "Análise e pasteurização",
            descricao = "O leite é analisado, pasteurizado e armazenado seguindo o protocolo nacional dos bancos de leite humano."
        ),
        EtapaJornada(
            numero = 4,
            titulo = "Vida que floresce",
            descricao = "Bebês prematuros recebem o alimento mais completo do mundo — e ganham fôlego para crescer."
        )
    )
}
