package com.dzdtech.primhesaplama.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.viewmodel.LoginActivityViewModel
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val logo = findViewById<ImageView>(R.id.logo)
        val animation = AnimationUtils.loadAnimation(this,R.anim.shake)

        logo.startAnimation(animation)

        //LoginActivityViewModel initialization
        val viewModel= ViewModelProvider(this).get(LoginActivityViewModel::class.java)

        //TODO: Login button geçici olarak mainaktiviteye aktarılıyor düzenlenecek.
        val loginButton = findViewById<View>(R.id.login) as Button
        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed(){
        val mBuilder = AlertDialog.Builder(this)
            .setTitle(getString(R.string.app_exit_title))
            .setMessage(getString(R.string.app_exit_message))
            .setPositiveButton(getString(R.string.app_exit_message_positive_btn), null)
            .setNegativeButton(getString(R.string.app_exit_mesaage_negative_btn), null)
            .show()

        val mPositiveButton = mBuilder.getButton(AlertDialog.BUTTON_POSITIVE)
        mPositiveButton.setOnClickListener {
            exitProcess(1)
        }
    }


}