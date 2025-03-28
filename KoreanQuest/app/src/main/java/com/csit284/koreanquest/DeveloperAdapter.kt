package com.csit284.koreanquest

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DeveloperAdapter(private val context: Activity, private val developers: List<Developer>) : BaseAdapter() {

    override fun getCount(): Int = developers.size
    override fun getItem(position: Int): Any = developers[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: context.layoutInflater.inflate(R.layout.list_item_developer, parent, false)

        val imgDeveloper = view.findViewById<ImageView>(R.id.img_developer)
        val tvName = view.findViewById<TextView>(R.id.tv_dev_name)
        val tvDescription = view.findViewById<TextView>(R.id.tv_dev_description)

        val developer = developers[position]

        imgDeveloper.setImageResource(developer.imageResId)
        tvName.text = developer.name
        tvDescription.text = developer.description

        return view
    }
}