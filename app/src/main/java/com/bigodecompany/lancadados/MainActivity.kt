package com.bigodecompany.lancadados

import android.content.res.TypedArray
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), DadoView {
    private lateinit var btnJogar: Button
    private lateinit var imgPrimeiroDado: ImageView
    private lateinit var imgSegundoDado: ImageView

    private val presenter = DadoPresenter(this)

    private val imgsDados: TypedArray by lazy {
        this.resources.obtainTypedArray(R.array.faces_dado)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setOnClickListeners()
    }

    private fun initViews() {
        btnJogar = findViewById(R.id.btnJogar)
        imgPrimeiroDado = findViewById(R.id.imgPrimeiroDado)
        imgSegundoDado = findViewById(R.id.imgSegundoDado)
    }

    private fun setOnClickListeners() {
        btnJogar.setOnClickListener {
            val intervalo = (1..6)
            presenter.jogarDados(intervalo)
        }
    }

    override fun apresentarPrimeiroDado(numero: Int) {
        imgPrimeiroDado.setImageDrawable(imgsDados.getDrawable(numero))
    }

    override fun apresentarSegundoDado(numero: Int) {
        imgSegundoDado.setImageDrawable(imgsDados.getDrawable(numero))
    }
}