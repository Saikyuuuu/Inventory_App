package com.example.inventory_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val keyboardBtn = findViewById<Button>(R.id.keyboardBtn)
        keyboardBtn.setOnClickListener{
            val intent = Intent(this,KeyboardTransactionActivity::class.java)
            startActivity(intent)
        }

        val mouseBtn = findViewById<Button>(R.id.mouseBtn)
        mouseBtn.setOnClickListener{
            val intent = Intent(this,MouseTransactionActivity::class.java)
            startActivity(intent)
        }

        val monitorBtn = findViewById<Button>(R.id.monitorBtn)
        monitorBtn.setOnClickListener{
            val intent = Intent(this,MonitorTransactionActivity::class.java)
            startActivity(intent)
        }

        val headsetBtn = findViewById<Button>(R.id.headsetBtn)
        headsetBtn.setOnClickListener{
            val intent = Intent(this,HeadsetTransactionActivity::class.java)
            startActivity(intent)
        }

        val cpuBtn = findViewById<Button>(R.id.cpuBtn)
        cpuBtn.setOnClickListener{
            val intent = Intent(this,CpuTransactionActivity::class.java)
            startActivity(intent)
        }
    }
}