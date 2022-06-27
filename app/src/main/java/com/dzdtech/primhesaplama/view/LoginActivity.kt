package com.dzdtech.primhesaplama.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog

import androidx.lifecycle.ViewModelProvider
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.databinding.ActivityLoginBinding

import com.dzdtech.primhesaplama.viewmodel.LoginActivityViewModel
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this,R.anim.shake)

        binding.logo.startAnimation(animation)
        //LoginActivityViewModel initialization
        val viewModel= ViewModelProvider(this)[LoginActivityViewModel::class.java]

        binding.login.setOnClickListener {

               if(binding.email.text.toString().length<8 ||binding.password.text.toString().length<5){
                   binding.loginWarning.text = getString(R.string.login_warning)
                   binding.loginWarning.visibility = View.VISIBLE
               }
                else{
                   binding.progressBar.visibility = View.VISIBLE
                   binding.loginWarning.visibility = View.GONE
                   viewModel.postRequest(binding.email.text.toString(), binding.password.text.toString())
               }

        }
        viewModel.loginResponse.observe(this){
            it?.let {
                if(it == -1){
                    binding.loginWarning.text = getString(R.string.login_warning_2)
                    binding.loginWarning.visibility = View.VISIBLE
                }
                else{
                    binding.progressBar.visibility = View.VISIBLE
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("id",it.toString())
                    startActivity(intent)
                    finish()
                }

                //Progress bar gizleme
                if (!viewModel.progress) {
                    binding.progressBar.visibility = View.GONE
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