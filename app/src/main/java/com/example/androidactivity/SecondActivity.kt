package com.example.androidactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.btn_back)
        val btnNext = findViewById<Button>(R.id.btn_next)

        btnBack.setOnClickListener (this)
        btnNext.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_back -> {
                    Toast.makeText(this, "Back button Click", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.btn_next ->{
                    Toast.makeText(this, "Next button Click", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, ThirdActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}