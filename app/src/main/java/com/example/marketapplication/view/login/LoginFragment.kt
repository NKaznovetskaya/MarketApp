package com.example.marketapplication.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.marketapplication.R
import com.example.marketapplication.databinding.FragmentLoginBinding
import com.example.marketapplication.view.base.BaseFragment
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : BaseFragment<FragmentLoginBinding>()  {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imgPhone = requireActivity().findViewById<ImageView>(R.id.imgPhone)
        imgPhone.setOnClickListener {
            (requireActivity() as LoginActivity).navigate(LoginFragmentDirections.toVerificationFragment())
        }



    }

}


