package com.dzdtech.primhesaplama.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.dzdtech.primhesaplama.R
@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val logo = findViewById<ImageView>(R.id.logo)
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        logo.startAnimation(animation)

        Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        }, 2500)
    }



}