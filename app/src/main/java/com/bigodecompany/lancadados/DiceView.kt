package com.bigodecompany.lancadados

interface DiceView {
    fun showFirstDiceSixFaces(numero: Int)
    fun showSecondDiceSixFaces(numero: Int)

    fun showFirstDiceEightFaces(numero: Int)
    fun showSecondDiceEightFaces(numero: Int)

    fun showError(message: String)
}