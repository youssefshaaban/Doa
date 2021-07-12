package com.example.doaa.second_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doaa.*
import com.example.doaa.base.BaseActivity
import com.example.doaa.databinding.ActivityHomeBinding
import com.example.doaa.visit_graves.VisitTheGravesActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    lateinit var binding: ActivityHomeBinding
    val strTitle: List<String> by lazy {
        listOf(getString(R.string.visit), getString(R.string.charity))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        binding.contactUs.setOnClickListener {
            startActivity(ContactUsActivity.getIntent(this))
        }
        binding.back.setOnClickListener {
            onBackPressed()
        }
        binding.rvTitles.layoutManager = LinearLayoutManager(this)
        binding.rvTitles.adapter = TitleAdapter(strTitle) {
            if (it == 0) {
                startActivity(VisitTheGravesActivity.getIntent(this))
            } else if (it == 1) {
                startActivity(DonationsAndCharitiesActivity.getIntent(this))
            }
        }
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }
}