package com.example.doaa

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.doaa.base.BaseFragment
import com.example.doaa.databinding.ActivityDisplayBinding
import com.example.doaa.databinding.FragmentControlMediaBinding
import com.example.doaa.enum.VisitGravits

/**
 * A simple [Fragment] subclass.
 * Use the [ControlMediaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ControlMediaFragment : BaseFragment<FragmentControlMediaBinding>() {
    lateinit var binding: FragmentControlMediaBinding
    var mp: MediaPlayer?=null
    lateinit var visitGravits: VisitGravits
    lateinit var audioManager: AudioManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("key")?.let {
            visitGravits=VisitGravits.valueOf(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=getViewDataBinding()
        mp=getMediaPlayer()
        audioManager = view.context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        binding.seekBar.min = audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC)
        binding.seekBar.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 7, 0)
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
            mp?.start()
        }
        binding.stop.setOnClickListener {
            mp?.stop()
            mp = getMediaPlayer()
        }
        binding.pause.setOnClickListener {
            mp?.pause()
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

    fun getMediaPlayer():MediaPlayer?{
        return when(visitGravits){
            VisitGravits.ayatalkarsaa -> {
                MediaPlayer.create(binding.root.context, R.raw.korsy)
            }
            VisitGravits.YASIN -> {
                MediaPlayer.create(binding.root.context, R.raw.yaseen)
            }
            VisitGravits.ELKHLAS -> {
                MediaPlayer.create(binding.root.context, R.raw.e5la9)
            }
            VisitGravits.ALMUEAWIDHATAYN -> {
                MediaPlayer.create(binding.root.context, R.raw.mo3awithatain)
            }
            VisitGravits.ELMOLK -> {
                MediaPlayer.create(binding.root.context, R.raw.almulk)
            }
            VisitGravits.ALAQDAR -> {
                MediaPlayer.create(binding.root.context, R.raw.alqadr)
            }
            VisitGravits.AL_FATIHAH -> {
                MediaPlayer.create(binding.root.context, R.raw.alfateha)
            }
            VisitGravits.ELRAHMAN -> {
                MediaPlayer.create(binding.root.context, R.raw.alrahman)
            }
            VisitGravits.DUA_GRAVES->{
                MediaPlayer.create(binding.root.context, R.raw.zyara_alqaboor)
            }
            VisitGravits.ALQADH->{
                MediaPlayer.create(binding.root.context, R.raw.alqadah)
            }
            VisitGravits.WARETH->{
                MediaPlayer.create(binding.root.context, R.raw.warith)
            }
            else->return null
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ControlMediaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ControlMediaFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_control_media
    }

    override fun onDestroy() {
        super.onDestroy()
        mp?.stop()
        mp?.reset()
    }
}