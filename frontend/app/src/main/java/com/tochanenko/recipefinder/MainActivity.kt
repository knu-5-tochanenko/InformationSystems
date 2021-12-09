package com.tochanenko.recipefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bottom_navigation_favorites -> {
                    true
                }
                R.id.bottom_navigation_search -> {
                    true
                }
                R.id.bottom_navigation_about -> {
                    true
                }
                else -> false
            }
        }
    }
}