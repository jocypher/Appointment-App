package com.example.appointmentapp.Activity

import android.content.Intent
import android.os.Bundle
import com.example.appointmentapp.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            getStartedBtn.setOnClickListener {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
        }

    }
}