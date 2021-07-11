package com.example.doaa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doaa.databinding.ActivityContactUsBinding

class ContactUsActivity : BaseActivity<ActivityContactUsBinding>() {
    lateinit var binding: ActivityContactUsBinding
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
        return R.layout.activity_contact_us
    }

    companion object{
        fun getIntent(context: Context): Intent = Intent(context,ContactUsActivity::class.java)
    }
}