package com.example.marketapplication.view.main.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentBottomSheetFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFilterFragment: BottomSheetDialogFragment() {

    val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBottomSheetFilterBinding
        get() = FragmentBottomSheetFilterBinding::inflate
    var binding: FragmentBottomSheetFilterBinding? = null

    companion object {
        const val TAG = "BottomSheetFilterFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}


