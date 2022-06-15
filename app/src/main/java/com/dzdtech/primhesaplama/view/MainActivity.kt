package com.dzdtech.primhesaplama.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dzdtech.primhesaplama.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(DashboardFragment())

        val bottomMenu = findViewById<BottomNavigationView>(R.id.bottom_menu)
        bottomMenu.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.dashboard ->{
                    loadFragment(DashboardFragment())
                    true
                }

                R.id.project ->{
                    loadFragment(ProjectFragment())
                    true
                }

                R.id.calls->{
                    loadFragment(CallFragment())
                    true
                }

                else -> false
            }
        }



    }

    //Ekrana ilgili fragment'i yükler
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}