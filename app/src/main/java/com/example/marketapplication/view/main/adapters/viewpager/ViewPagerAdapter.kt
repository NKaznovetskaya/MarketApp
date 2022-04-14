package com.example.marketapplication.view.main.adapters.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.marketapplication.utils.ViewPagerUtils
import com.example.marketapplication.view.main.bottomnav.ads.ActiveAdsFragment
import com.example.marketapplication.view.main.bottomnav.ads.ArchiveAdsFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = when(position) {
            0 -> ActiveAdsFragment()
            else -> ArchiveAdsFragment()
        }

        fragment.arguments = Bundle().apply {
            putInt(ViewPagerUtils.ARG_PAGE, position + 1)
        }
        return fragment
    }
}