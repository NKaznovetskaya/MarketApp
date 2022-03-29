package com.example.marketapplication.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.marketapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.NavigationUI.setupWithNavController


class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_main_host_fragment)
        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.nav_view)
        setupWithNavController(bottomNavigationView, navController)


    }









}