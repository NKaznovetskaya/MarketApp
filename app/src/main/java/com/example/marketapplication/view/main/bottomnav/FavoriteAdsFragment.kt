package com.example.marketapplication.view.main.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentFavoriteAdsBinding
import com.example.marketapplication.utils.ObjectsGeneratorUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.adapters.sneakers.SneakersAdapter

class FavoriteAdsFragment : BaseFragment<FragmentFavoriteAdsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFavoriteAdsBinding
        get() = FragmentFavoriteAdsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sneakersAdapter = SneakersAdapter()
        binding.rvSneakers.adapter = sneakersAdapter
    }

}