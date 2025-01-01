package com.example.jokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.jokeapp.data.api.RetrofitInstance
import kotlinx.coroutines.launch
import com.example.jokeapp.databinding.ActivityMainBinding
import android.content.Intent


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // val buttonGetJoke: Button = findViewById(R.id.buttonGetJoke) - ilman bindingia

        fetchJoke()

        binding.buttonGetJoke.setOnClickListener {
            fetchJoke()
        }

        binding.buttonGoToAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }


    private fun fetchJoke() {

        lifecycleScope.launch {
            try {
                if(binding.radioSingle.isChecked) {
                    val response = RetrofitInstance.api.getSingleJoke()
                    println(response)
                    binding.jokeTextView.text = response.joke
                    binding.categoryTextView.text = "Category: ${response.category}"
                    binding.typeTextView.text = "Type: ${response.type}"
                }
                if(binding.radioTwoPart.isChecked) {
                    val response = RetrofitInstance.api.getTwoPartJoke()
                    binding.jokeTextView.text = response.setup + "\n\n" + response.delivery
                    binding.categoryTextView.text = "Category: ${response.category}"
                    binding.typeTextView.text = "Type: ${response.type}"
                }

            } catch (e: Exception) {
                binding.jokeTextView.text = "Error"
            }
        }
    }
}