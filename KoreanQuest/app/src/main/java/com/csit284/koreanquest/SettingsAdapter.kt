package com.csit284.koreanquest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible

class SettingsAdapter(private val context: Context, private val settingsList: MutableList<SettingOption>) :
    ArrayAdapter<SettingOption>(context, R.layout.item_setting, settingsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_setting, parent, false)
        val setting = settingsList[position]

        val titleTextView = view.findViewById<TextView>(R.id.setting_title)
        val toggleSwitch = view.findViewById<Switch>(R.id.setting_switch)
        val dropdownSpinner = view.findViewById<Spinner>(R.id.setting_spinner)
        val decreaseButton = view.findViewById<Button>(R.id.setting_decrease)
        val increaseButton = view.findViewById<Button>(R.id.setting_increase)
        val valueText = view.findViewById<TextView>(R.id.setting_value)
        val actionButton = view.findViewById<Button>(R.id.setting_button)

        titleTextView.text = setting.title

        when (setting.type) {
            SettingType.SWITCH -> {
                toggleSwitch.isVisible = true
                toggleSwitch.setOnCheckedChangeListener { _, isChecked ->
                    Toast.makeText(context, "${setting.title} ${if (isChecked) "Enabled" else "Disabled"}", Toast.LENGTH_SHORT).show()
                }
            }
            SettingType.DROPDOWN -> {
                dropdownSpinner.isVisible = true
                val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, setting.options!!)
                dropdownSpinner.adapter = adapter
                dropdownSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        Toast.makeText(context, "${setting.title}: ${setting.options[position]}", Toast.LENGTH_SHORT).show()
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            }
            SettingType.INCREMENT_DECREMENT -> {
                decreaseButton.isVisible = true
                increaseButton.isVisible = true
                valueText.isVisible = true
                valueText.text = setting.value.toString()

                decreaseButton.setOnClickListener {
                    if (setting.value > 0) {
                        setting.value -= 10
                        valueText.text = setting.value.toString()
                    }
                }
                increaseButton.setOnClickListener {
                    if (setting.value < 100) {
                        setting.value += 10
                        valueText.text = setting.value.toString()
                    }
                }
            }
            SettingType.BUTTON -> {
                actionButton.isVisible = true
                actionButton.text = "Reset"
                actionButton.setOnClickListener {
                    Toast.makeText(context, "${setting.title} reset!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}