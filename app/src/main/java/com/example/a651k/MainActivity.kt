package com.example.a651k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

   lateinit var btnStartService: Button
    lateinit var btnStopService: Button
    lateinit var tvServiceInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStartService = findViewById(R.id.btnStartService)
        btnStartService.setOnClickListener{
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tvServiceInfo = findViewById(R.id.tvServiceInfo)
                tvServiceInfo.text = "Service is running"
            }
        }

        btnStopService = findViewById(R.id.btnStoptService)
        btnStopService.setOnClickListener{
            MyIntentService.stopService()
            tvServiceInfo.text = "Service is stopped"
        }
    }
}