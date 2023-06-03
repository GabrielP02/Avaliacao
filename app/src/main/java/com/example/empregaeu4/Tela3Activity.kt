package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Tela3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela3)

        val button = findViewById<Button>(R.id.button5)
        button.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            val intent = Intent(this, ListaPacientesActivity::class.java)
            startActivity(intent)
        }
    }
}