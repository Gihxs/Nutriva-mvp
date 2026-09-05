package com.github.gihxs.nutriva_mvp.data

import com.github.gihxs.nutriva_mvp.model.Posto

object PostosMock {
    val lista = listOf(
        Posto(1, "Banco de Leite HC-USP", "Banco de Leite", "CEP 05403-900 Av. Dr. Enéas, 255 – Cerqueira César, São Paulo/SP", "Segunda à Sexta · 7h às 17h", 1.2, "(11) 00000-0001"),
        Posto(2, "Posto Vila Mariana", "Posto de Coleta", "CEP 04010-200 R. Domingos de Morais, 1820 – Vila Mariana, São Paulo/SP", "Segunda à Sábado · 8h às 16h", 2.8, "(11) 00000-0002"),
        Posto(3, "BLH Maternidade Santa Joana", "Banco de Leite", "CEP 04103-000 R. do Paraíso, 432 – Paraíso, São Paulo/SP", "Todos os dias · 24h", 3.4,"(11) 00000-0003"),
        Posto(4, "Posto de Coleta Vila Prudente", "Posto de Coleta", "CEP 03221-200 Av. do Oratório, 1200 – Vila Prudente, São Paulo/SP", "Segunda à Sexta · 8h às 18h", 4.1, "(11) 00000-0004")
    )
}
