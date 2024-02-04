package com.example.inventory_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.inventory_app.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.jar.Attributes.Name

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        This line of code directly move to login page when SignUpBtn is clicked
//        val registerBtn = findViewById<Button>(R.id.SignUpBtn)
//        registerBtn.setOnClickListener{
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }


        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()

        binding.signIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.SignUpBtn.setOnClickListener{
            val name = binding.NameSignUp.text.toString()
            val email = binding.EmailSignUp.text.toString()
            val password = binding.PasswordSignUp.text.toString()
            val confirmpass = binding.ConfirmPassword.text.toString()

            if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmpass.isNotEmpty()) {
                if (password == confirmpass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText( this, "Password do not match!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText( this, "Please fill empty fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

