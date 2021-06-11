package com.bigodecompany.lancadados

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), DiceView {
    private lateinit var txtPlayerName: TextView
    private lateinit var imgFirstDice: ImageView
    private lateinit var imgSecondDice: ImageView
    private lateinit var btnPlay: Button
    private lateinit var fabShare: FloatingActionButton

    private val presenter = DicePresenter(this)

    private val imagesDiceSixFaces: TypedArray by lazy {
        this.resources.obtainTypedArray(R.array.dado_6_faces)
    }
    private val imagesDiceEightFaces: TypedArray by lazy {
        this.resources.obtainTypedArray(R.array.dado_8_faces)
    }
    private val playerName: String by lazy {
        intent.getStringExtra(EXTRA_PLAYER_NAME).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setOnClickListeners()
    }

    private fun initViews() {
        txtPlayerName = findViewById(R.id.txtPlayerName)
        imgFirstDice = findViewById(R.id.imgFirstDice)
        imgSecondDice = findViewById(R.id.imgSecondDice)
        btnPlay = findViewById(R.id.btnPlay)
        fabShare = findViewById(R.id.fabShare)

        txtPlayerName.text = getString(R.string.welcome, playerName)
    }

    private fun setOnClickListeners() {
        btnPlay.setOnClickListener {
            val numberOfFaces = 6
            presenter.jogarDados(numberOfFaces)
        }

        fabShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_INTENT, "voce é sortudo!")
                setPackage("com.whatsapp")
                type = "text/plain"
            }

            if (intent.resolveActivity(this.packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.share_fail), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun showFirstDiceSixFaces(drawableId: Int) {
        imgFirstDice.setImageDrawable(imagesDiceSixFaces.getDrawable(drawableId))
    }

    override fun showSecondDiceSixFaces(drawableId: Int) {
        imgSecondDice.setImageDrawable(imagesDiceSixFaces.getDrawable(drawableId))
    }

    override fun showFirstDiceEightFaces(drawableId: Int) {
        imgFirstDice.setImageDrawable(imagesDiceEightFaces.getDrawable(drawableId))
    }

    override fun showSecondDiceEightFaces(drawableId: Int) {
        imgSecondDice.setImageDrawable(imagesDiceEightFaces.getDrawable(drawableId))
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val EXTRA_PLAYER_NAME = "playerName"

        fun open(context: Context, playerName: String) {
            context.startActivity(Intent(context, MainActivity::class.java).apply {
                putExtra(EXTRA_PLAYER_NAME, playerName)
            })
        }
    }
}