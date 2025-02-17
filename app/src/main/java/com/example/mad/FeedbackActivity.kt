package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feedback)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val response = findViewById<TextView>(R.id.rateRespond)
        val but= findViewById<Button>(R.id.button);
        val feedbackInput=findViewById<EditText>(R.id.text);

        findViewById<RatingBar>(R.id.rate).setOnRatingBarChangeListener { _, rating, _ ->
            val rate = rating.toInt() // Convert Float to Int

            val message = when (rate) {
                5 -> "Awesome. I love it"
                4 -> "Good, Enjoyed it"
                3 -> "Satisfied"
                2 -> "Not Good"
                1 -> "Disappointed"
                else -> ""
            }

            response.text = message // Set the message in TextView
        }
        but.setOnClickListener{
            val feedback=feedbackInput.getText().toString().trim();

            if(feedback.isEmpty()){
                Toast.makeText(this,"Please enter feedback",Toast.LENGTH_SHORT).show();
            }else{
                val intent=Intent(this,FeedbackResultActivity::class.java).apply{
                    putExtra("feedback",feedback);
                }
                startActivity(intent);
            }
        }
    }
}