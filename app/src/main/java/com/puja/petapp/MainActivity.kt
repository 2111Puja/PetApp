package com.puja.petapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // Declaring a lateinit variable to hold a reference to the "Open" Button
    private lateinit var openButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the openButton by finding the Button view with the ID "openButton"
        openButton = findViewById(R.id.openButton)

        // Setting an OnClickListener to handle button clicks
        openButton.setOnClickListener {
            // Creating an Intent to navigate to the Second_Page activity
            val intent = Intent(this, Second_Page::class.java)
            // Starting the Second_Page activity
            startActivity(intent)
        }
    }
}
