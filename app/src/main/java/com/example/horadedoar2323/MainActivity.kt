package com.example.horadedoar2323

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.horadedoar2323.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.LENGTH_SHORT

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.btLogin.setOnClickListener {
            val nome = binding.editemail.text.toString()
            val senha = binding.editsenha.text.toString()

            when{
                nome.isEmpty() -> {
                mensagem(it,"Coloque o seu Nome!")
                } senha.isEmpty() -> {
                    mensagem(it,"Coloque a Senha!")
                }senha.length <=5 -> {
                    mensagem(it,"A senha precisa ter pelo menos 6 caracteres")
                }else -> {
                    navegarPraMenu (nome)
                }
            }
        }
    }

    private fun mensagem (view: View,mensagem: String){
        val snackbar = Snackbar.make(view,mensagem, LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFF"))
        snackbar.show()

    }
    private fun navegarPraMenu (nome: String) {
        val intent = Intent(this , menu::class.java)
        intent.putExtra ("nome" ,nome)
        startActivity(intent)
    }
}
