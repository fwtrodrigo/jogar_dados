package com.bigodecompany.lancadados

interface DiceView {
    fun showFirstDiceSixFaces(diceId: Int)
    fun showSecondDiceSixFaces(diceId: Int)

    fun showFirstDiceEightFaces(diceId: Int)
    fun showSecondDiceEightFaces(diceId: Int)

    fun showError(message: String)
}