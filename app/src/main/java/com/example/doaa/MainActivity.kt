package com.example.doaa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doaa.databinding.ActivityMainBinding
import com.example.doaa.second_activity.HomeActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        binding.home.setOnClickListener {
            startActivity(HomeActivity.getIntent(this))
        }
        binding.gift.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
    companion object{
        fun getIntent(context: Context): Intent = Intent(context,MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    }
}