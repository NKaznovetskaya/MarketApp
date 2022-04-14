package com.example.marketapplication.view.main.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.R
import com.example.marketapplication.databinding.FragmentAdsBinding
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.adapters.viewpager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class AdsFragment : BaseFragment<FragmentAdsBinding>() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAdsBinding
        get() = FragmentAdsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = if (position == 0) getString(R.string.active) else getString(R.string.archive)

        }.attach()

    }
}