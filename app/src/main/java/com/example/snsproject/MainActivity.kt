package com.example.snsproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.example.snsproject.detailpage.DetailPageActivity

class MainActivity : AppCompatActivity() {

    private lateinit var et_container: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_container = findViewById(R.id.et_container)
        val make_tv_button = findViewById<Button>(R.id.make_tv_button)

        make_tv_button.setOnClickListener {
            val new_textView = TextView(this)
            new_textView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            new_textView.hint = "new"
            new_textView.setTextSize(30F)

            Log.d("SIZE", "사이즈 출력")
            new_textView.setTextColor(Color.GREEN)

            Log.d("SIZE", "컬러 출력")

            et_container.addView(new_textView)

            new_textView.setOnClickListener {
                val intent = Intent(this, DetailPageActivity::class.java)
                startActivity(intent)
            }
        }

    }
}