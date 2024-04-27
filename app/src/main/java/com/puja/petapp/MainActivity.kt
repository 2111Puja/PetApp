package com.puja.petapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //making use of the keyword lateinit
    //this allows to declare variables and initialize at a later stage
    private lateinit var openButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find reference to the button bu using its ID
        //initialize the variable by making use of its findviewby ID method

        openButton = findViewById(R.id.startButton)

        //making the button clickable
        //we are making use of the onsetClickListener
        //creating an Intent to access the MainActivity

        openButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}