package com.example.marketapplication.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.marketapplication.R


class VerificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_verification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnVerification = requireActivity().findViewById<AppCompatButton>(R.id.btnVerification)
        btnVerification.setOnClickListener {
            (requireActivity() as LoginActivity).navigate(VerificationFragmentDirections.toPasswordFragment())
        }

    }


}