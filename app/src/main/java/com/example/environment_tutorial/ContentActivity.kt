package com.example.environment_tutorial

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        val tvText: TextView = findViewById(R.id.titleText)
        val tvContent: TextView = findViewById(R.id.content_text)
        val im: ImageView = findViewById(R.id.im)

        tvText.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")
        im.setImageResource(intent.getIntExtra("image", R.drawable.clio))



    }
}