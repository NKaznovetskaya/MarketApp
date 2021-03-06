package com.example.marketapplication.view.main.sneakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.marketapplication.databinding.FragmentDescriptionSneakersBinding
import com.example.marketapplication.utils.ObjectsGeneratorUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.adapters.gallery.GalleryAdapter

class DescriptionSneakersFragment : BaseFragment<FragmentDescriptionSneakersBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDescriptionSneakersBinding
        get() = FragmentDescriptionSneakersBinding::inflate


    val removeIsPossible by lazy { DescriptionSneakersFragmentArgs.fromBundle(requireArguments()).removeIsPossible }
    val sneakers by lazy { DescriptionSneakersFragmentArgs.fromBundle(requireArguments()).sneakers }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDeleteAds.isVisible = removeIsPossible
        binding.clSellerData.isVisible = !removeIsPossible

        binding.tvDescription.text = sneakers.description
        binding.tvLength.text = sneakers.length.toString()
        binding.tvWidth.text = sneakers.width.toString()
        binding.tvNameSneakers.text = sneakers.name
        binding.tvPrice.text = sneakers.price.toString()
        binding.tvMaterial.text = sneakers.material
        binding.tvSizeTitle.text = sneakers.sizeType
        binding.tvSize.text = sneakers.size.toString()

        val galleryAdapter = GalleryAdapter()
        binding.rvGallery.adapter = galleryAdapter
        galleryAdapter.setItems(ObjectsGeneratorUtils.galleryList())

    }


}

