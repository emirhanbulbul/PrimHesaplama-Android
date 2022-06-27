package com.dzdtech.primhesaplama.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.databinding.SplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: SplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.logo.startAnimation(animation)

        Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
        }, 2500)
    }



}