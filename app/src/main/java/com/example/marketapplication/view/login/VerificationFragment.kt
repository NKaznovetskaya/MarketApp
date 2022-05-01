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

          val isPhoneValid = validatePhone()

          if (isPhoneValid) {
              val phone =
                  binding.tilPhoneNumber.prefixText.toString() + binding.etNumber.text.toString()
              (requireActivity() as LoginActivity).navigate(
                  VerificationFragmentDirections.toPasswordFragment(
                      phone
                  )
              )
          }

        }

    }

    private fun validatePhone(): Boolean {
        if (binding.etNumber.text.toString().trim().isEmpty() || binding.etNumber.length() < 9) {
            binding.tilPhoneNumber.error = "Номер введено невірно"
            binding.etNumber.requestFocus()
            return false
        } else {
            binding.tilPhoneNumber.isErrorEnabled = false
        }
        return true
    }


    }



