package com.bigodecompany.lancadados

class DicePresenter(private val view: DiceView) {

    private fun obterNumeroAleatorio(quantidadeFaces: Int = 6): Int =
        (0 until quantidadeFaces).random()

    fun throwDices(quantidadeFaces: Int) {
        val dado1 = obterNumeroAleatorio(quantidadeFaces)
        val dado2 = obterNumeroAleatorio(quantidadeFaces)

        if (quantidadeFaces != 6 && quantidadeFaces != 8) {
//            val v = view as MainActivity
//            val msg = v.applicationContext.resources.getString(R.string.erro_tipo_dado)
            view.showError("Tipo de dado desconhecido. Esperado 6 ou 8 lados")
            return
        }

        if (quantidadeFaces == 6) {
            view.showFirstDiceSixFaces(dado1)
            view.showSecondDiceSixFaces(dado2)
        }

        if (quantidadeFaces == 8) {
            view.showFirstDiceEightFaces(dado1)
            view.showSecondDiceEightFaces(dado2)
        }
    }
}