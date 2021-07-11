package com.example.doaa.test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doaa.BaseActivity
import com.example.doaa.DonationsAndCharitiesActivity
import com.example.doaa.R
import com.example.doaa.databinding.ActivityQuranImageBinding

class QuranImageActivity : BaseActivity<ActivityQuranImageBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    companion object{
        fun getIntent(context: Context): Intent = Intent(context, QuranImageActivity::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_quran_image
    }
}