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
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.progress_Bar
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val logo = findViewById<ImageView>(R.id.logo)
        val animation = AnimationUtils.loadAnimation(this,R.anim.shake)

        logo.startAnimation(animation)

        //LoginActivityViewModel initialization
        val viewModel= ViewModelProvider(this)[LoginActivityViewModel::class.java]

        val loginButton = findViewById<View>(R.id.login) as Button
        loginButton.setOnClickListener {

               if(email?.text.toString().length<8 ||password?.text.toString().length<5){
                   loginWarning?.text = "Lütfen geçerli bir e-posta ve şifre giriniz!"
                   loginWarning?.visibility = View.VISIBLE
               }
                else{
                   progress_Bar?.visibility = View.VISIBLE
                   loginWarning?.visibility = View.GONE
                   viewModel.postRequest(email?.text.toString(), password?.text.toString())
               }

        }
        viewModel.loginResponse.observe(this){
            it?.let {
                if(it == -1){
                    loginWarning?.text = "E-posta veya şifre hatalı!"
                    loginWarning?.visibility = View.VISIBLE
                }
                else{
                    progress_Bar?.visibility = View.VISIBLE
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("id",it.toString())
                    startActivity(intent)
                    finish()
                }

                //Progress bar gizleme
                if (!viewModel.progress) {
                    progress_Bar?.visibility = View.GONE
                }

            }



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