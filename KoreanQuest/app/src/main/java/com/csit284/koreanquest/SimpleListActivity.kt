package com.csit284.koreanquest

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class SimpleListActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)

        // Sample data for the list
        val languages = arrayOf("Korean", "Japanese", "Chinese", "English", "Spanish", "French")

        // Find ListView from XML
        val listView = findViewById<ListView>(R.id.list_view)

        // Create ArrayAdapter (default Android layout)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)

        // Attach adapter to ListView
        listView.adapter = adapter

        // Handle List Item Clicks
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedLanguage = languages[position]
            Toast.makeText(this, "You selected: $selectedLanguage", Toast.LENGTH_SHORT).show()
        }
    }
}
