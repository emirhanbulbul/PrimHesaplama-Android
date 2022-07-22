package com.dzdtech.primhesaplama.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.services.Constants
import com.dzdtech.primhesaplama.view.calls_screen.CallFragment
import com.dzdtech.primhesaplama.view.project_screen.ProjectFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val idValue = intent.getStringExtra("id").toString()

        val idName = intent.getStringExtra("name").toString()
        val idSurname = intent.getStringExtra("surname").toString()
        Constants.idValue = idValue
        Constants.userName = idName
        Constants.userSurname = idSurname

        loadFragment(DashboardFragment())


        val bottomMenu = findViewById<BottomNavigationView>(R.id.bottom_menu)
        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard -> {
                    loadFragment(DashboardFragment())
                    true
                }

                R.id.project -> {
                    loadFragment(ProjectFragment())
                    true
                }

                R.id.calls -> {
                    loadFragment(CallFragment())
                    true
                }

                R.id.profile -> {
                    loadFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }


    }


    //Ekrana ilgili fragment'i yükler
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}