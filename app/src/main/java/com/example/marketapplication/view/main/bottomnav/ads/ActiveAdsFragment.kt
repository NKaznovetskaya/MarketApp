package com.example.marketapplication.view.main.bottomnav.ads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentActiveAdsBinding
import com.example.marketapplication.utils.ObjectsGeneratorUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.MainActivity
import com.example.marketapplication.view.main.adapters.sneakers.SneakersAdapter
import com.example.marketapplication.view.main.MainNavFragmentDirections


class ActiveAdsFragment : BaseFragment<FragmentActiveAdsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentActiveAdsBinding
        get() = FragmentActiveAdsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sneakersAdapter = SneakersAdapter()
        binding.rvSneakers.adapter = sneakersAdapter

        sneakersAdapter.itemClickListener = {
            (requireActivity() as MainActivity).navigate(MainNavFragmentDirections.toDescriptionSneakersFragment(true))
        }

    }
}


