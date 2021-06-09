package com.bigodecompany.lancadados

class DadoPresenter(private val view: DadoView) {

    private fun obterNumeroAleatorio(intervalo: IntRange = (1..6)): Int = intervalo.random()

    fun jogarDados(intervalo: IntRange) {
        val dado1 = obterNumeroAleatorio(intervalo)
        view.apresentarPrimeiroDado(dado1)

        val dado2 = obterNumeroAleatorio(intervalo)
        view.apresentarSegundoDado(dado2)
    }
}