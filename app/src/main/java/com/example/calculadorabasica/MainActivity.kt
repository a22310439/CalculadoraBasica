package com.example.calculadorabasica

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos en la interfaz
        val Numero1 = findViewById<EditText>(R.id.Numero1)
        val Numero2 = findViewById<EditText>(R.id.Numero2)
        val Resultado = findViewById<TextView>(R.id.Resultado)

        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)
        val btnMultiplicacion = findViewById<Button>(R.id.btnMultiplicacion)
        val btnDivision = findViewById<Button>(R.id.btnDivision)

        // Función para validar si los campos están vacíos
        fun validarCampos(): Boolean {
            if (Numero1.text.isEmpty()){
                Numero1.error = "Campo requerido"
            }else if (Numero2.text.isEmpty()){
                Numero2.error = "Campo requerido"
            }else {
                return true
            }
            return false
        }

        // Suma
        btnSuma.setOnClickListener {
            if (validarCampos()) {
                val num1 = Numero1.text.toString().toDouble()
                val num2 = Numero2.text.toString().toDouble()
                val resultado = num1 + num2
                Resultado.text = "Resultado: $resultado"
            }
        }

        // Resta
        btnResta.setOnClickListener {
            if (validarCampos()) {
                val num1 = Numero1.text.toString().toDouble()
                val num2 = Numero2.text.toString().toDouble()
                val resultado = num1 - num2
                Resultado.text = "Resultado: $resultado"
            }
        }

        // Multiplicación
        btnMultiplicacion.setOnClickListener {
            if (validarCampos()) {
                val num1 = Numero1.text.toString().toDouble()
                val num2 = Numero2.text.toString().toDouble()
                val resultado = num1 * num2
                Resultado.text = "Resultado: $resultado"
            }
        }

        // División
        btnDivision.setOnClickListener {
            if (validarCampos()) {
                val num1 = Numero1.text.toString().toDouble()
                val num2 = Numero2.text.toString().toDouble()
                if (num2 == 0.0) {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_LONG).show()
                } else {
                    val resultado = num1 / num2
                    Resultado.text = "Resultado: $resultado"
                }
            }
        }
    }
}
