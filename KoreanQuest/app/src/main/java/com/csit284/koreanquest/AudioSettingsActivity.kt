package com.csit284.koreanquest

import android.app.Activity
import android.os.Bundle
import android.widget.*

class AudioSettingsActivity : Activity() {
    private var volumeLevel = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_settings)

        val btnIncrease = findViewById<Button>(R.id.btn_increase_volume)
        val btnDecrease = findViewById<Button>(R.id.btn_decrease_volume)
        val tvVolume = findViewById<TextView>(R.id.tv_volume)
        val switchMusic = findViewById<Switch>(R.id.switch_music)
        val switchSfx = findViewById<Switch>(R.id.switch_sfx)
        val btnBack = findViewById<Button>(R.id.btn_back_audio)

        btnIncrease.setOnClickListener {
            if (volumeLevel < 100) {
                volumeLevel += 5
                tvVolume.text = volumeLevel.toString()
            }
        }

        btnDecrease.setOnClickListener {
            if (volumeLevel > 0) {
                volumeLevel -= 5
                tvVolume.text = volumeLevel.toString()
            }
        }

        switchMusic.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, if (isChecked) "Music On" else "Music Off", Toast.LENGTH_SHORT).show()
        }

        switchSfx.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, if (isChecked) "Sound Effects On" else "Sound Effects Off", Toast.LENGTH_SHORT).show()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
