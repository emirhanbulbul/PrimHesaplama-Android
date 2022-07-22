package com.dzdtech.primhesaplama.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.databinding.ActivityLoginBinding
import com.dzdtech.primhesaplama.viewmodel.LoginActivityViewModel
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Beni Hatırla verilerini shared preferences'de saklıyoruz.
        sharedPreferences = this.getSharedPreferences(
            "dzdtechprimhesaplama",
            Context.MODE_PRIVATE
        )//Oluşturma


        val animation = AnimationUtils.loadAnimation(this, R.anim.shake)

        binding.logo.startAnimation(animation)
        //LoginActivityViewModel initialization
        val viewModel = ViewModelProvider(this)[LoginActivityViewModel::class.java]


        val email = sharedPreferences.getString("email", "")
        val password = sharedPreferences.getString("password", "")
        binding.email.setText(email)
        binding.password.setText(password)


        binding.login.setOnClickListener {

            if (binding.email.text.toString().length < 8 || binding.password.text.toString().length < 3) {
                binding.loginWarning.text = getString(R.string.login_warning)
                binding.loginWarning.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.VISIBLE
                binding.loginWarning.visibility = View.GONE
                viewModel.postRequest(
                    binding.email.text.toString(),
                    binding.password.text.toString()
                )
            }

        }

        viewModel.response.observe(this) {
            binding.loginWarning.text = getString(R.string.login_warning_2)
            binding.loginWarning.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }

        viewModel.loginResponse.observe(this) {
            it?.let {

                // Beni Hatırla Seçili İse Verileri Kaydet
                if (binding.rememberMe.isChecked) {
                    sharedPreferences.edit().putString("email", binding.email.text.toString())
                        .apply()
                    sharedPreferences.edit().putString("password", binding.password.text.toString())
                        .apply()
                } else {
                    sharedPreferences.edit().remove("email").apply()
                    sharedPreferences.edit().remove("password").apply()
                }
                binding.loginWarning.visibility = View.GONE
                binding.progressBar.visibility = View.GONE

                binding.progressBar.visibility = View.VISIBLE
                Intent(this, MainActivity::class.java).apply {
                    putExtra("id",it.id.toString())
                    putExtra("name", it.name)
                    putExtra("surname", it.surname)
                }.also {
                    startActivity(it)
                    finish()
                }


            }


        }
    }

    override fun onBackPressed() {
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