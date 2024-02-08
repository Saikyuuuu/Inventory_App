package com.example.inventory_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.inventory_app.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




//        val logInBtn = findViewById<Button>(R.id.LoginBtn)
//        logInBtn.setOnClickListener{
//            val intent = Intent(this,DashboardActivity::class.java)
//            startActivity(intent)
//        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.Register.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


        binding.LoginBtn.setOnClickListener{
            val email = binding.Email.text.toString()
            val password = binding.Password.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword( email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this, OnboardingActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText( this, "Please fill all the fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

