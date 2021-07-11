package com.example.doaa.test

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.doaa.App
import com.example.doaa.BaseActivity
import com.example.doaa.DonationsAndCharitiesActivity
import com.example.doaa.R
import com.example.doaa.databinding.ActivityQuranTextBinding
import com.tazkiyatech.quran.sdk.database.QuranDatabase

class QuranTextActivity : BaseActivity<ActivityQuranTextBinding>() {
    lateinit var binding: ActivityQuranTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        val quranDatabase = QuranDatabase(App.context)
        quranDatabase.openDatabase()
        val ayahs: List<String> = quranDatabase.getAyahsInSurah(1)
        binding.seekBar.min = 15
        binding.seekBar.max =40
        binding.seekBar.progress=20
        binding.content.text=getStringFromAyahs(ayahs)
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               binding.content.textSize=progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }
    private fun getStringFromAyahs(ayahs: List<String>):String {
        val str :StringBuilder= StringBuilder()
        for ((indx, value) in ayahs.withIndex()){
            str.append(value + "  ( ${indx + 1} )  ")
        }
        return str.toString()
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_quran_text
    }
    companion object{
        fun getIntent(context: Context): Intent = Intent(context, QuranTextActivity::class.java)
    }
}