package com.example.doaa.display

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.example.doaa.App
import com.example.doaa.BaseActivity
import com.example.doaa.R
import com.example.doaa.databinding.ActivityDisplayBinding
import com.example.doaa.enum.VisitGravits
import com.tazkiyatech.quran.sdk.database.QuranDatabase


class DisplayQuranActivity : BaseActivity<ActivityDisplayBinding>() {
    lateinit var binding: ActivityDisplayBinding
    lateinit var mp: MediaPlayer
    lateinit var visitGravits: VisitGravits
    lateinit var audioManager: AudioManager
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        intent.getStringExtra("key")?.let {
            visitGravits=VisitGravits.valueOf(it)
        }
        mp = getMediaPlayer()
        audioManager = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        binding.seekBar.min = audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC)
        binding.seekBar.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 7, 0)
        binding.seekBar.progress = 7
        val quranDatabase = QuranDatabase(App.context)
        quranDatabase.openDatabase()
        val ayahs: List<String> = quranDatabase.getAyahsInSurah(2)
        binding.content.text=getStringFromAyahs(ayahs)
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        onClickListner()
    }

    private fun onClickListner() {
        binding.play.setOnClickListener {
            mp.start()
        }
        binding.stop.setOnClickListener {
            mp.stop()
            mp = getMediaPlayer()
        }
        binding.pause.setOnClickListener {
            mp.pause()
        }
        binding.minus.setOnClickListener {
            binding.seekBar.progress = binding.seekBar.progress - 1
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.seekBar.progress, 0)
        }
        binding.plus.setOnClickListener {
            binding.seekBar.progress = binding.seekBar.progress + 1
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.seekBar.progress, 0)
        }
    }

    private fun getStringFromAyahs(ayahs: List<String>):String {
        val str :StringBuilder= StringBuilder()
        for ((indx, value) in ayahs.withIndex()){
            str.append(value + "  ( ${indx + 1} )  ")
        }
       return str.toString()
    }

    fun getMediaPlayer():MediaPlayer{
        return when(visitGravits){
            VisitGravits.ayatalkarsaa -> {
                MediaPlayer.create(this, R.raw.korsy)
            }
            VisitGravits.YASIN -> {
                MediaPlayer.create(this, R.raw.yaseen)
            }
            VisitGravits.ELKHLAS -> {
                MediaPlayer.create(this, R.raw.e5la9)
            }
            VisitGravits.ALMUEAWIDHATAYN -> {
                MediaPlayer.create(this, R.raw.mo3awithatain)
            }
            VisitGravits.ELMOLK -> {
                MediaPlayer.create(this, R.raw.almulk)
            }
            VisitGravits.ALAQDAR -> {
                MediaPlayer.create(this, R.raw.alqadr)
            }
            VisitGravits.AL_FATIHAH -> {
                MediaPlayer.create(this, R.raw.alfateha)
            }
            VisitGravits.ELRAHMAN -> {
                MediaPlayer.create(this, R.raw.alrahman)
            }
            else-> MediaPlayer.create(this, R.raw.alfateha)
        }
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_display
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, DisplayQuranActivity::class.java)
    }
}