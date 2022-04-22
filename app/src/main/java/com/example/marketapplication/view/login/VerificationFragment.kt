package com.example.marketapplication.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentVerificationBinding
import com.example.marketapplication.view.base.BaseFragment

class VerificationFragment : BaseFragment<FragmentVerificationBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVerificationBinding
        get() = FragmentVerificationBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVerification.setOnClickListener {
            val phone = binding.tilPhoneNumber.prefixText.toString() + binding.etNumber.text.toString()
            (requireActivity() as LoginActivity).navigate(VerificationFragmentDirections.toPasswordFragment(phone))
        }

    }



}