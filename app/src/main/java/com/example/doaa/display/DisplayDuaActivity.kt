package com.example.doaa.display

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.example.doaa.BaseActivity
import com.example.doaa.R
import com.example.doaa.databinding.ActivityDisplayBinding
import com.example.doaa.databinding.ActivityDisplayDuaBinding
import com.example.doaa.enum.VisitGravits


class DisplayDuaActivity : BaseActivity<ActivityDisplayDuaBinding>() {
    lateinit var binding: ActivityDisplayDuaBinding
    lateinit var mp: MediaPlayer

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        val audioManager = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        binding.seekBar.min = audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC)
        binding.seekBar.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 7, 0)
        binding.seekBar.progress = 7
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        binding.play.setOnClickListener {
            mp.start()
        }
        binding.stop.setOnClickListener {
            mp.stop()
        }
        binding.pause.setOnClickListener {
            mp.pause()
        }
        binding.plus.setOnClickListener { }
        binding.minus.setOnClickListener {
            binding.seekBar.progress = binding.seekBar.progress - 1
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.seekBar.progress, 0)
        }
        binding.plus.setOnClickListener {
            binding.seekBar.progress = binding.seekBar.progress + 1
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.seekBar.progress, 0)
        }
    }

    fun getMediaPlayer():MediaPlayer?{
        return null
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_display
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, DisplayDuaActivity::class.java)
    }
}