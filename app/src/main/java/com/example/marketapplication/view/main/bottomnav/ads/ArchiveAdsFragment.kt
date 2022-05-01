package com.example.marketapplication.view.main.bottomnav.ads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentArchiveAdsBinding
import com.example.marketapplication.domain.model.Sneakers
import com.example.marketapplication.domain.storage.StoragePreference
import com.example.marketapplication.utils.ObjectsGeneratorUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.MainActivity
import com.example.marketapplication.view.main.MainNavFragmentDirections
import com.example.marketapplication.view.main.adapters.sneakers.SneakersAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ArchiveAdsFragment : BaseFragment<FragmentArchiveAdsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentArchiveAdsBinding
        get() = FragmentArchiveAdsBinding::inflate
    lateinit var db: FirebaseFirestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sneakersAdapter = SneakersAdapter()
        binding.rvSneakers.adapter = sneakersAdapter
        db = Firebase.firestore

        val storagePreference = StoragePreference(requireContext())
        val userId = storagePreference.userId()

        sneakersAdapter.itemClickListener = { sneakers ->
            (requireActivity() as MainActivity).navigate(
                MainNavFragmentDirections.toDescriptionSneakersFragment(
                    removeIsPossible =  false, sneakers = sneakers))
        }

        db.collection("sneakers")
            .get()
            .addOnSuccessListener {
                val activeSneakersList = mutableListOf<Sneakers>()

                for (sneakersMap in it.documents) {
                    val ownerId = sneakersMap["owner_id"] as String
                    val isArchive = sneakersMap["is_archive"] as Boolean

                    if (ownerId == userId && isArchive) {
                        val name = sneakersMap["name"] as String
                        val size = sneakersMap["size"] as Long
                        val sizeType = sneakersMap["size_type"] as String
                        val material = sneakersMap["material"] as String
                        val length = sneakersMap["length"] as Long
                        val width = sneakersMap["width"] as Long
                        val price = sneakersMap["price"] as Long
                        val description = sneakersMap["description"] as String

                        val sneakers = Sneakers(
                            ownerId = ownerId,
                            name = name,
                            size = size,
                            sizeType = sizeType,
                            material = material,
                            length = length,
                            width = width,
                            price = price,
                            description = description
                        )

                        activeSneakersList.add(sneakers)
                    }
                }
                sneakersAdapter.setItems(activeSneakersList)
            }
    }

}