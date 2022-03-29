package com.example.marketapplication.view.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.marketapplication.R
import com.example.marketapplication.view.login.LoginActivity


class SplashFragment : Fragment() {

    private val mainHandler = Handler(Looper.getMainLooper())

    companion object {
        const val SPLASH_TIME = 3000L
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainHandler.postDelayed({
            (requireActivity() as LoginActivity).navigate(SplashFragmentDirections.toLoginFragment())
        }, SPLASH_TIME)
    }

}