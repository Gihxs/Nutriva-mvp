package com.github.gihxs.nutriva_mvp.viewmodel

import androidx.lifecycle.ViewModel
import com.github.gihxs.nutriva_mvp.data.TriagemMock
import com.github.gihxs.nutriva_mvp.model.PerguntaTriagem
import com.github.gihxs.nutriva_mvp.model.ResultadoTriagem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TriagemViewModel : ViewModel() {

    val perguntas: List<PerguntaTriagem> = TriagemMock.perguntas

    private val _respostas = MutableStateFlow<Map<Int, Boolean>>(emptyMap())
    val respostas: StateFlow<Map<Int, Boolean>> = _respostas.asStateFlow()

    fun responder(perguntaId: Int, resposta: Boolean) {
        _respostas.value = _respostas.value.toMutableMap().apply {
            put(perguntaId, resposta)
        }
    }

    fun todasRespondidas(): Boolean = _respostas.value.size == perguntas.size

    fun avaliarElegibilidade(): ResultadoTriagem {
        val r = _respostas.value
        if (!todasRespondidas()) return ResultadoTriagem.PENDENTE

        val elegivel = r[1] == true && r[2] == false && r[3] == true && r[4] == false
        return if (elegivel) ResultadoTriagem.ELEGIVEL else ResultadoTriagem.NAO_ELEGIVEL
    }
}
