package com.example.doaa.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.doaa.R

class TestAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_app)
        findViewById<Button>(R.id.image).setOnClickListener {
            startActivity(QuranImageActivity.getIntent(this))
        }
        findViewById<Button>(R.id.text).setOnClickListener {
            startActivity(QuranTextActivity.getIntent(this))
        }
    }
}