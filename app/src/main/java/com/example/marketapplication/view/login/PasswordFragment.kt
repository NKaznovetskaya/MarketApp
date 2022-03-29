package com.example.marketapplication.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.marketapplication.R

class PasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val btnNext = requireActivity().findViewById<AppCompatButton>(R.id.btnNext)
         btnNext.setOnClickListener {
             (requireActivity() as LoginActivity).navigate(PasswordFragmentDirections.toDataFragment())
         }
    }
}