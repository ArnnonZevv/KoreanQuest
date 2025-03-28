package com.csit284.koreanquest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class LandingActivity : Activity() {
    private lateinit var btnLoginLogout: Button
    private lateinit var btnProfile: Button
    private var isLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        btnLoginLogout = findViewById(R.id.btn_login_logout)
        val btnSettings = findViewById<Button>(R.id.btn_settings)

        val prefs = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        isLoggedIn = prefs.getBoolean("isLoggedIn", false)

        updateUI()

        btnLoginLogout.setOnClickListener {
            isLoggedIn = !isLoggedIn
            prefs.edit().putBoolean("isLoggedIn", isLoggedIn).apply() // Save state
            updateUI()
        }

        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun updateUI() {
        btnLoginLogout.text = if (isLoggedIn) "Log out" else "Login"
        btnProfile.isEnabled = isLoggedIn
    }
}
