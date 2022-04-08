package com.example.marketapplication.view.main.bottomnav

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentSettingsBinding
import com.example.marketapplication.view.base.BaseFragment

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding
        get() = FragmentSettingsBinding::inflate
}