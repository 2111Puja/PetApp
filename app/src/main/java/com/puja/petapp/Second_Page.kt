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

    //Declaring variables
    private var hunger = 30
    private var cleanliness = 60
    private var happiness = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

    //Declare the buttons
    val cleanButton = findViewById<Button>(R.id.cleanButton)
    val feedButton = findViewById<Button>(R.id.feedButton)
    val playButton = findViewById<Button>(R.id.playButton)
        val image = findViewById<ImageView>(R.id.imageView2)

        //To Initialise the Feed button
        updateUI()
        feedButton.setOnClickListener {
            feedPet()
            updateUI()

            //To shift the image

            image.setImageResource(R.drawable.eating)
        }

        //To Initialise the Clean Button
        cleanButton.setOnClickListener {
            cleanPet()
            updateUI()

            //To shift the image
            image.setImageResource(R.drawable.bathing)
        }

        //To initialise the Play Button
        playButton.setOnClickListener {
            playWithPet()
            updateUI()

            //To shift the image
            image.setImageResource(R.drawable.playing)
        }
    }

    //feedPet Method
    private fun feedPet() {
        hunger += 5
        happiness +=10
        if (hunger > 100) happiness -=5
        cleanliness -= 5
        if (happiness > 100) happiness -=15
        if (hunger <0) hunger += 5
        if (happiness < 0) happiness += 0
        if (cleanliness == 0) cleanliness += 5
        if (cleanliness == 0) happiness -= 10
    }

    //playWithPet Method
    private fun playWithPet() {
        happiness += 5
        hunger -= 10
        cleanliness -= 15
        if (happiness > 100) happiness == 100
        if (hunger < 0) hunger += 5
        if (cleanliness == 0) cleanliness +=5
        if (hunger ==0) happiness -= 10
        if (cleanliness == 0) happiness -=10
    }
    //cleanPet Method
    private fun cleanPet() {
        happiness +=5
        cleanliness += 10
        if (happiness > 100) happiness == 100
        if (hunger < 0) hunger += 4
        if (happiness <0) happiness == 0
        if (cleanliness == 0) cleanliness +=5
        if (hunger == 0) happiness -= 10

    }
    //updateUI Method
    private fun updateUI() {

        //To Declare the 3 sets
        val textViewHappy = findViewById<TextView>(R.id.textViewHappy)
        val textViewHunger = findViewById<TextView>(R.id.textViewHunger)
        val textViewClean = findViewById<TextView>(R.id.textViewClean)

        //To initialise the 3 sets
        textViewHappy.text = "Happy: $happiness"
        textViewHunger.text = "Hunger: $hunger"
        textViewClean.text = "Cleanliness: $cleanliness"

    }
}