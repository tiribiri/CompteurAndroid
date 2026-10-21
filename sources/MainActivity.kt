package com.example.compteurandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var compteur = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewCompteur = findViewById<TextView>(R.id.textViewCompteur)
        val buttonIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val buttonDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val buttonReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)
        val buttonPlus5 = findViewById<Button>(R.id.buttonPlus5)
        val buttonMoins5 = findViewById<Button>(R.id.buttonMoins5)

        fun updateCompteur() {
            textViewCompteur.text = compteur.toString()
            when {
                compteur > 0 -> textViewCompteur.setTextColor(getColor(android.R.color.holo_green_dark))
                compteur < 0 -> textViewCompteur.setTextColor(getColor(android.R.color.holo_red_dark))
                else -> textViewCompteur.setTextColor(getColor(android.R.color.black))
            }
        }

        updateCompteur()

        buttonIncrementer.setOnClickListener {
            compteur++
            updateCompteur()
        }

        buttonDecrementer.setOnClickListener {
            if (compteur > 0) {
                compteur--
                updateCompteur()
            }
        }

        buttonPlus5.setOnClickListener {
            compteur += 5
            updateCompteur()
        }

        buttonMoins5.setOnClickListener {
            if (compteur >= 5) {
                compteur -= 5
                updateCompteur()
            }
        }

        buttonReinitialiser.setOnClickListener {
            compteur = 0
            updateCompteur()
            Toast.makeText(this, "Compteur réinitialisé", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("compteur", compteur)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        compteur = savedInstanceState.getInt("compteur")
        val textViewCompteur = findViewById<TextView>(R.id.textViewCompteur)
        textViewCompteur.text = compteur.toString()
    }
}
