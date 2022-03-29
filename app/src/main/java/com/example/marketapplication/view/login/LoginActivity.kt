package com.example.marketapplication.view.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.marketapplication.R


class LoginActivity: AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        navController = Navigation.findNavController(this, R.id.nav_login_host_fragment)

    }

    fun navigate(destination: NavDirections) {
        navController.currentDestination?.getAction(destination.actionId)?.let { action ->
            navController.navigate(action.destinationId)
        }
    }

}





