package com.csit284.koreanquest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        val btnGeneral = findViewById<Button>(R.id.btn_general)
        val btnAudio = findViewById<Button>(R.id.btn_audio)
        val btnVideo = findViewById<Button>(R.id.btn_video)
        val btnDevelopers = findViewById<Button>(R.id.btn_developers)

        btnGeneral.setOnClickListener {
            startActivity(Intent(this, GeneralSettingsActivity::class.java))
        }

        btnAudio.setOnClickListener {
            startActivity(Intent(this, AudioSettingsActivity::class.java))
        }

        btnVideo.setOnClickListener {
            startActivity(Intent(this, VideoSettingsActivity::class.java))
        }

        btnDevelopers.setOnClickListener {
            startActivity(Intent(this, DevelopersActivity::class.java))
        }
    }
}