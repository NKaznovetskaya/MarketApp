package com.example.marketapplication.view.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.marketapplication.R
import com.example.marketapplication.databinding.FragmentDataBinding
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.bottomnav.MainActivity

class DataFragment : BaseFragment<FragmentDataBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDataBinding
        get() = FragmentDataBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnDone = requireActivity().findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }


}

