package com.example.doaa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.doaa.base.BaseActivity
import com.example.doaa.databinding.ActivityDonationsAndCharitiesBinding

class DonationsAndCharitiesActivity : BaseActivity<ActivityDonationsAndCharitiesBinding>() {
    lateinit var binding: ActivityDonationsAndCharitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=getViewDataBinding()
        binding.home.setOnClickListener {
            onBackPressed()
        }
        binding.start.setOnClickListener {
            startActivity(MainActivity.getIntent(this))
            finishAffinity()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_donations_and_charities
    }

    companion object{
        fun getIntent(context: Context): Intent = Intent(context,DonationsAndCharitiesActivity::class.java)
    }
}