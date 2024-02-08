package com.example.inventory_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inventory_app.databinding.ActivityLoginBinding
import com.example.inventory_app.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inventoryBtn.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
        binding.PosBtn.setOnClickListener{
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }
    }
}