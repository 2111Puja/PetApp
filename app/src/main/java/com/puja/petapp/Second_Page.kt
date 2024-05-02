package com.puja.petapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.puja.petapp.R.drawable.pet_happy
import kotlin.random.Random

class Second_Page : AppCompatActivity() {

    private lateinit var feedButton: Button
    private lateinit var cleanButton: Button
    private lateinit var playButton: Button
    private lateinit var petImageView: ImageView
    private lateinit var statusTextView: TextView

    private var happinessLevel = 50
    private var hygieneLevel = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        // Initialize views
        petImageView = findViewById(R.id.petImageView)
        feedButton = findViewById(R.id.feedButton)
        cleanButton = findViewById(R.id.cleanButton)
        playButton = findViewById(R.id.playButton)

        updateStatus()

        feedButton.setOnClickListener {
            feedPet()
            updateUI()
            petImageView.setImageResource(R.drawable.dog_eating)
        }

        cleanButton.setOnClickListener {
            cleanPet()
            updateUI()
            petImageView.setImageResource(R.drawable.dog_bathing)
        }

        playButton.setOnClickListener {
            playWithPet()
            updateStatus()
            updateUI()
            petImageView.setImageResource(R.drawable.dog_playing)
        }

        // Schedule periodic updates for the pet's status
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                simulateTimePassing()
                updateStatus()
                handler.postDelayed(this, 5000) // Update every 5 seconds
            }
        }, 5000) // Start after 5 seconds
    }

    private fun updateUI() {
        statusTextView.text = "Happiness: $happinessLevel%\nHygiene: $hygieneLevel%"
    }

    private fun feedPet() {
        happinessLevel += 10
        if (happinessLevel > 100) {
            happinessLevel = 100
        }
    }

    private fun cleanPet() {
        hygieneLevel += 20
        if (hygieneLevel > 100) {
            hygieneLevel = 100
        }
    }

    private fun playWithPet() {
        happinessLevel += 30
        if (happinessLevel > 100) {
            happinessLevel = 100
        }
    }

    private fun simulateTimePassing() {
        // Decrease happiness and hygiene over time
        happinessLevel -= Random.nextInt(3, 6)
        if (happinessLevel < 0) {
            happinessLevel = 0
        }

        hygieneLevel -= Random.nextInt(2, 5)
        if (hygieneLevel < 0) {
            hygieneLevel = 0
        }
    }

    private fun updateStatus() {
        statusTextView.text = "Happiness: $happinessLevel%\nHygiene: $hygieneLevel%"

        // Update pet image based on happiness and hygiene levels
        if (happinessLevel >= 70 && hygieneLevel >= 70) {
            petImageView.setImageResource(R.drawable.pet_happy)
        } else if (happinessLevel < 30 && hygieneLevel < 30) {
            petImageView.setImageResource(R.drawable.pet_sad)
        } else {
            petImageView.setImageResource(R.drawable.pet_normal)
        }
    }
}
