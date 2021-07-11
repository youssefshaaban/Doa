package com.example.doaa.visit_graves

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doaa.BaseActivity
import com.example.doaa.ContactUsActivity
import com.example.doaa.R
import com.example.doaa.data.Visit
import com.example.doaa.databinding.ActivityVisitTheGravesBinding
import com.example.doaa.display.DisplayQuranActivity
import com.example.doaa.enum.VisitGravits
import com.example.doaa.second_activity.HomeActivity

class VisitTheGravesActivity : BaseActivity<ActivityVisitTheGravesBinding>() {
    lateinit var binding: ActivityVisitTheGravesBinding
    val visit:List<Visit> by lazy {
        listOf(Visit(getString(R.string.dua_visit), VisitGravits.DUA_GRAVES,2),
            Visit(getString(R.string.al_fatihah), VisitGravits.AL_FATIHAH,1),
            Visit(getString(R.string.alqadr), VisitGravits.ALAQDAR,1),
            Visit(getString(R.string.ELKHLAS), VisitGravits.ELKHLAS,1),
            Visit(getString(R.string.ALMUEAWIDHATAYN), VisitGravits.ALMUEAWIDHATAYN,1),
            Visit(getString(R.string.AYATELKORSE), VisitGravits.ayatalkarsaa,1),
            Visit(getString(R.string.yasin), VisitGravits.YASIN,1),
            Visit(getString(R.string.elmolk), VisitGravits.ELMOLK,1),
            Visit(getString(R.string.rahman), VisitGravits.ELRAHMAN,1),
            Visit(getString(R.string.qadah), VisitGravits.ALQADH,2),
            Visit(getString(R.string.ashora), VisitGravits.ASHORA,2),
            Visit(getString(R.string.wareth), VisitGravits.WARETH,2)
            )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=getViewDataBinding()
        binding.rvTitles.layoutManager=LinearLayoutManager(this)
        binding.rvTitles.adapter=TitleVisitGravesAdapter(visit,::handelClickItem)
        binding.contactUs.setOnClickListener {
            startActivity(ContactUsActivity.getIntent(this))
        }
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun handelClickItem(i: Int) {
        val item=visit[i]
        when(item.type){
            1->startActivity(DisplayQuranActivity.getIntent(this).putExtra("key",item.visitGravit.name))
            2->startActivity(DisplayQuranActivity.getIntent(this).putExtra("key",item.visitGravit))
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_visit_the_graves
    }

    companion object{
        fun getIntent(context: Context): Intent = Intent(context, VisitTheGravesActivity::class.java)
    }

}