package com.csit284.koreanquest

import android.app.Activity
import android.os.Bundle
import android.widget.*

class VideoSettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_settings)

        val listView = findViewById<ListView>(R.id.video_settings_list)
        val btnBack = findViewById<Button>(R.id.btn_back_video)

        val settings = mutableListOf(
            SettingOption("Select Resolution", SettingType.DROPDOWN, listOf("720p", "1080p", "1440p", "4K")),
            SettingOption("Select Frame Rate", SettingType.DROPDOWN, listOf("30 FPS", "60 FPS", "120 FPS")),
            SettingOption("Brightness", SettingType.INCREMENT_DECREMENT, value = 50),
            SettingOption("Contrast", SettingType.INCREMENT_DECREMENT, value = 50),
            SettingOption("Enable VSync", SettingType.SWITCH)
        )

        val adapter = SettingsAdapter(this, settings)
        listView.adapter = adapter

        btnBack.setOnClickListener {
            finish()
        }
    }
}
