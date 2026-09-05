package com.github.gihxs.nutriva_mvp.viewmodel

import androidx.lifecycle.ViewModel
import com.github.gihxs.nutriva_mvp.data.PostosMock
import com.github.gihxs.nutriva_mvp.model.Posto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PostosViewModel : ViewModel() {

    private val _postos = MutableStateFlow(PostosMock.lista)
    val postos: StateFlow<List<Posto>> = _postos.asStateFlow()

    private val _busca = MutableStateFlow("")
    val busca: StateFlow<String> = _busca.asStateFlow()

    fun buscarPorNomeOuCep(texto: String) {
        _busca.value = texto
        _postos.value = if (texto.isBlank()) {
            PostosMock.lista
        } else {
            PostosMock.lista.filter {
                it.nome.contains(texto, ignoreCase = true) ||
                        it.endereco.contains(texto, ignoreCase = true)
            }
        }
    }

    fun buscarPorId(id: Int): Posto? = PostosMock.lista.find { it.id == id }
}
