package com.mikyle.tamagotchiapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnFeed = findViewById<Button>(R.id.btn_feed)
        val btnClean = findViewById<Button>(R.id.btn_clean)
        val btnPlay = findViewById<Button>(R.id.btn_play)
        val txtHunger = findViewById<EditText>(R.id.txt_Hunger)
        val txtHealth = findViewById<EditText>(R.id.txt_Health)
        val txtClean = findViewById<EditText>(R.id.txt_Cleanliness)
        val petImage = findViewById<ImageView>(R.id.pet_image)

        // Initial display of the pet stats
        txtHunger.setText(petHunger.toString())
        txtHealth.setText(petHealth.toString())
        txtClean.setText(petCleanliness.toString())

        // Define click listeners for each button
        btnFeed.setOnClickListener {
            petHunger += 10
            petHealth += 10
            petCleanliness += 5
            updateStats(txtHunger, txtHealth, txtClean)
            animateImageChange(petImage, R.drawable.img_3)
        }

        btnClean.setOnClickListener {
            petCleanliness += 10
            petHealth += 10
            updateStats(txtHunger, txtHealth, txtClean)
            animateImageChange(petImage, R.drawable.img_2)
        }

        btnPlay.setOnClickListener {
            petHealth += 10
            petHunger += 5
            petCleanliness -= 5
            updateStats(txtHunger, txtHealth, txtClean)
            animateImageChange(petImage, R.drawable.img_1)
        }
    }

    private fun updateStats(txtHunger: EditText, txtHealth: EditText, txtClean: EditText) {
        // Ensure stats remain within bounds
        petHunger = petHunger.coerceIn(0, 100)
        petHealth = petHealth.coerceIn(0, 100)
        petCleanliness = petCleanliness.coerceIn(0, 100)

        txtHunger.setText(petHunger.toString())
        txtHealth.setText(petHealth.toString())
        txtClean.setText(petCleanliness.toString())
    }

    private fun animateImageChange(petImage: ImageView, newImageResId: Int) {
        // Implement your animation logic here (example: fade in/out, transition, etc.)
        petImage.setImageResource(newImageResId)
    }
}



