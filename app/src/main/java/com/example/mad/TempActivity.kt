package com.example.mad

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_temp)
        val fahrenheitInput = findViewById<EditText>(R.id.Fahrenheit)
        val celsiusOut = findViewById<EditText>(R.id.Celsius)
        val convert = findViewById<Button>(R.id.button)

        convert.setOnClickListener {
            val fahrenheitText = fahrenheitInput.text.toString()
            val celsiusText = celsiusOut.text.toString()

            if (fahrenheitText.isNotEmpty()) {
                val fahrenheit = fahrenheitText.toInt()
                val celsius = (fahrenheit - 32) * 5 / 9
                celsiusOut.setText(celsius.toString())
            } else if (celsiusText.isNotEmpty()) {
                val celsius = celsiusText.toInt()
                val fahrenheit = (celsius * 9 / 5) + 32
                fahrenheitInput.setText(fahrenheit.toString())
            } else {
                Toast.makeText(this, "Please enter a valid value!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
