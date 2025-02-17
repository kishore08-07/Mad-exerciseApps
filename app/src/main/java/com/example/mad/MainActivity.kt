package com.example.mad

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.Ex1Temp).setOnClickListener{
            startActivity(Intent(this,TempActivity::class.java))
        }

        findViewById<Button>(R.id.Ex1Emoji).setOnClickListener{
            startActivity(Intent(this,EmojiActivity::class.java))
        }

        findViewById<Button>(R.id.Ex2Linear).setOnClickListener{
            startActivity(Intent(this,LinearLayoutActivity::class.java))
        }

        findViewById<Button>(R.id.Ex2Relative).setOnClickListener{
            startActivity(Intent(this,RelativeLayoutActivity::class.java))
        }

        findViewById<Button>(R.id.Ex2Feedback).setOnClickListener{
            startActivity(Intent(this,FeedbackActivity::class.java))
        }
    }
}