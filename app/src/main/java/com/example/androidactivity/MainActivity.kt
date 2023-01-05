package com.example.androidactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btnClick = findViewById(R.id.btn_change_activity) as Button

    }

    fun clickButton(v: View) {
        Toast.makeText(applicationContext, "Button click", Toast.LENGTH_LONG).show()
        var intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}