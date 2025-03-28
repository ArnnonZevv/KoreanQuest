package com.csit284.koreanquest

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class GeneralSettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_settings)

        val listView = findViewById<ListView>(R.id.settings_list)
        val backButton = findViewById<Button>(R.id.btn_back)

        val settings = mutableListOf(
            SettingOption("Enable Dark Mode", SettingType.SWITCH),
            SettingOption("Select Language", SettingType.DROPDOWN, listOf("English", "Korean", "Japanese")),
            SettingOption("Enable Notifications", SettingType.SWITCH),
            SettingOption("Text Size", SettingType.INCREMENT_DECREMENT, value = 50),
            SettingOption("Reset Settings", SettingType.BUTTON)
        )

        val adapter = SettingsAdapter(this, settings)
        listView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }
    }
}
