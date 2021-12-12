package com.tochanenko.recipefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var searchFragment: SearchFragment
    lateinit var aboutFragment: AboutFragment
    lateinit var favoritesFragment: FavoritesFragment
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var currentFragment: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
    }

    private fun connectViews() {
        this.searchFragment = SearchFragment()
        this.aboutFragment = AboutFragment()
        this.favoritesFragment = FavoritesFragment()
        this.bottomNavigation = findViewById(R.id.bottom_navigation)
        setCurrentFragment(this.searchFragment)

        bottomNavigation.selectedItemId = R.id.bottom_navigation_search

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bottom_navigation_favorites -> {
                    setCurrentFragment(this.favoritesFragment)
                    true
                }
                R.id.bottom_navigation_search -> {
                    setCurrentFragment(this.searchFragment)
                    true
                }
                R.id.bottom_navigation_about -> {
                    setCurrentFragment(this.aboutFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        this.currentFragment = fragment::class.java.toString()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }
}