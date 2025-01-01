package com.example.jokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.jokeapp.databinding.ActivityAboutBinding

class AboutActivity : ComponentActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBackToMain.setOnClickListener {
            finish() // Palaa takaisin aktiviteetin laukaisijaan -> main
        }
    }
}