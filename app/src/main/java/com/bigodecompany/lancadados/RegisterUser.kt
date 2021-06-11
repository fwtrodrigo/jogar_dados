package com.bigodecompany.lancadados

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterUser : AppCompatActivity() {
    private lateinit var edtPlayerName: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
        initViews()
        setOnClicks()
    }

    private fun initViews() {
        edtPlayerName = findViewById(R.id.edtPlayerName)
        btnRegister = findViewById(R.id.btnRegister)
    }

    private fun setOnClicks() {
        btnRegister.setOnClickListener {
            MainActivity.open(this, edtPlayerName.text.toString())
        }
    }
}