package com.example.doaa.display

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.doaa.App
import com.example.doaa.ControlMediaFragment
import com.example.doaa.base.BaseActivity
import com.example.doaa.R
import com.example.doaa.databinding.ActivityDisplayBinding
import com.example.doaa.enum.VisitGravits
import com.tazkiyatech.quran.sdk.database.QuranDatabase


class DisplayQuranActivity : BaseActivity<ActivityDisplayBinding>() {
    lateinit var binding: ActivityDisplayBinding
    lateinit var visitGravits: VisitGravits
    val list:List<Int> by lazy {
        listOf(R.drawable.first,R.drawable.second)
    }
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        intent.getStringExtra("key")?.let {
            visitGravits=VisitGravits.valueOf(it)
        }
        supportFragmentManager.beginTransaction().replace(R.id.controlMedia,ControlMediaFragment().apply {
            arguments=Bundle().apply {
                putString("key",this@DisplayQuranActivity.visitGravits.name)
            }
        }).commit()
        binding.pager.adapter=AyatAdapter(list)
//        val quranDatabase = QuranDatabase(App.context)
//        quranDatabase.openDatabase()
//        val ayahs: List<String> = quranDatabase.getAyahsInSurah(2)
//        binding.content.text=getStringFromAyahs(ayahs)
    }


//    private fun getStringFromAyahs(ayahs: List<String>):String {
//        val str :StringBuilder= StringBuilder()
//        for ((indx, value) in ayahs.withIndex()){
//            str.append(value + "  ( ${indx + 1} )  ")
//        }
//       return str.toString()
//    }

    override fun getLayoutId(): Int {
        return R.layout.activity_display
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, DisplayQuranActivity::class.java)
    }
}