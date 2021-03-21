package com.example.calculadoranotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = btnCalcular
        val outMedia = media
        val outFaltas = faltas
        val outStatus = status

        btnCalcular.setOnClickListener {
            val nota1 = Integer.parseInt(notaum.text.toString())
            val nota2 = Integer.parseInt(nota2.text.toString())
            val nota3 = Integer.parseInt(nota3.text.toString())
            val nota4 = Integer.parseInt(nota4.text.toString())
            val nfaltas = Integer.parseInt(nfaltas.text.toString())

            val mediaAluno = (nota1 + nota2 + nota3 + nota4) / 4
            val percFaltas = nfaltas * 100 / 50
            val statusAluno:String?
            // Testando média e mudando a cor
            if (mediaAluno >= 6) {
                outMedia.setTextColor(Color.GREEN)
            } else {
                outMedia.setTextColor(Color.RED)
            }
            // Testando faltas e mudando a cor
            if (percFaltas < 25) {
                outFaltas.setTextColor(Color.GREEN)
            } else {
                outFaltas.setTextColor(Color.RED)
            }
            // Testando status final e colorizando
            if (mediaAluno >= 6 && percFaltas < 25) {
                statusAluno = "Aprovado"
                outStatus.setTextColor(Color.GREEN)
            } else {
                statusAluno = "Reprovado"
                outStatus.setTextColor(Color.RED)
            }
            outMedia.setText(mediaAluno.toString())
            outFaltas.setText(percFaltas.toString() + "%")
            outStatus.setText(statusAluno)
        }
    }
}