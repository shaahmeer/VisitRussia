package com.example.visitrussia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.visitrussia.databinding.ActivityMainStarterBinding

class MainActivityStarter : AppCompatActivity() {
    private lateinit var binding: ActivityMainStarterBinding // Correct the type of binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainStarterBinding.inflate(layoutInflater) // Initialize binding using inflate method
        val view = binding.root
        setContentView(view)

        val imageView = binding.imageView4

        imageView.setOnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
    }
}
