package com.example.lab2_2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2_2.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var word: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startGame()
    }

    private fun startGame() {
        word = getWord()
        binding.Word.text = shuffleString(word)
        binding.send.setOnClickListener{
            if (binding.Input.text.toString() == word) {
                word = getWord()
                binding.Word.text = shuffleString(word)
                binding.Input.text = null
                Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getWord(): String {
        val word = resources.getStringArray(R.array.words);
        return word[Random.nextInt(word.size)];
    }

    private fun shuffleString(word: String): String? {
        val letters = word.toMutableList()
        letters.shuffle()
        var shuffled: String? = ""
        for (letter in letters) {
            shuffled += letter
        }
        return shuffled
    }
}