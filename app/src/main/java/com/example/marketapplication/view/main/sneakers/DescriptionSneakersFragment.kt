package com.example.marketapplication.view.main.sneakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentDescriptionSneakersBinding
import com.example.marketapplication.utils.ObjectsGeneratorUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.adapters.gallery.GalleryAdapter

class DescriptionSneakersFragment : BaseFragment<FragmentDescriptionSneakersBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDescriptionSneakersBinding
        get() = FragmentDescriptionSneakersBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val galleryAdapter = GalleryAdapter()
        binding.rvGallery.adapter = galleryAdapter
        galleryAdapter.setItems(ObjectsGeneratorUtils.galleryList())

    }

}

