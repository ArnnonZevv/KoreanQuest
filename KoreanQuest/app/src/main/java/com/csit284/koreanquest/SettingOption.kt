package com.csit284.koreanquest

data class SettingOption(
    val title: String,
    val type: SettingType,
    val options: List<String>? = null,
    var value: Int = 50
)

enum class SettingType {
    SWITCH, DROPDOWN, INCREMENT_DECREMENT, BUTTON
}
