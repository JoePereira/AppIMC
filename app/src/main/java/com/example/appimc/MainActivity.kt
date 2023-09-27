package com.example.appimc

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rbMasc = findViewById<RadioButton>(R.id.rbMasc)
        val rbFem = findViewById<RadioButton>(R.id.rbFem)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnPesoIdeal = findViewById<Button>(R.id.btnPesoIdeal)

        btnPesoIdeal.setOnClickListener(View.OnClickListener{
            if(!rbMasc.isChecked && !rbFem.isChecked){
                showAlert("Por favor, escolha o sexo")
                return@OnClickListener
            }
            val altura = etAltura.text.toString().toDouble()

            val pesoIdeal : Double = if(rbMasc.isChecked){
                (72.7 * altura) - 58
            } else {
                (62.1 * altura) - 44.7
            }

            val formatedPesoIdeal = DecimalFormat("#.0")
            val mensagem = "Peso Ideal = ${formatedPesoIdeal.format(pesoIdeal)} Kg"
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
        })




    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Informações Pendentes!")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }
}