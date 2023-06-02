package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.empregaeu4.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioNome = binding.tvUsuarioNome
        val nome = intent.getStringExtra("nome")
        usuarioNome.text = nome

        val button = findViewById<Button>(R.id.btNext)
        button.setOnClickListener {
            val intent = Intent(this, Tela3Activity::class.java)
            startActivity(intent)
        }
    }
}