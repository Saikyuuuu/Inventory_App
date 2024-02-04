package com.example.inventory_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

     val signUpBtn = findViewById<Button>(R.id.RegisterBtn)
        signUpBtn.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        val logInBtn = findViewById<Button>(R.id.LoginBtn)
        logInBtn.setOnClickListener{
            val intent = Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}

