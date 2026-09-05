package com.github.gihxs.nutriva_mvp.data

import com.github.gihxs.nutriva_mvp.model.FaqItem

object FaqMock {
    val lista = listOf(
        FaqItem(1, "Quem pode doar leite materno?",
            "Toda nutriz saudável que esteja amamentando, com produção excedente, sem uso de medicamentos contraindicados e com exames pré-natais em dia."),
        FaqItem(2, "É seguro? O leite passa por algum controle?",
            "Sim. Todo leite doado passa por triagem, pasteurização e análise de qualidade seguindo o protocolo nacional da Rede de Bancos de Leite Humano."),
        FaqItem(3, "Como coletar o leite em casa?",
            "A equipe do posto orienta sobre higienização das mãos, esterilização dos vidros e armazenamento em freezer até a entrega."),
        FaqItem(4, "Quanto preciso doar?",
            "Não existe quantidade mínima obrigatória. Qualquer volume excedente já ajuda bebês prematuros internados.")
    )
}
