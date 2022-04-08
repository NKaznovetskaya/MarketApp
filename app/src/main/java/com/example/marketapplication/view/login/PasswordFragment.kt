package com.example.marketapplication.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.marketapplication.R
import com.example.marketapplication.databinding.FragmentPasswordBinding
import com.example.marketapplication.view.base.BaseFragment

class PasswordFragment : BaseFragment<FragmentPasswordBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPasswordBinding
        get() = FragmentPasswordBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val btnNext = requireActivity().findViewById<AppCompatButton>(R.id.btnNext)
         btnNext.setOnClickListener {
             (requireActivity() as LoginActivity).navigate(PasswordFragmentDirections.toDataFragment())
         }
    }
}