package com.example.marketapplication.view.main.adapters.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentNewSneakersBinding
import com.example.marketapplication.view.base.BaseFragment

class NewSneakersFragment : BaseFragment<FragmentNewSneakersBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewSneakersBinding
        get() = FragmentNewSneakersBinding::inflate

}