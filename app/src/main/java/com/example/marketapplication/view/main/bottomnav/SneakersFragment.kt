package com.example.marketapplication.view.main.bottomnav

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentSneakersBinding
import com.example.marketapplication.domain.model.Sneakers
import com.example.marketapplication.utils.ObjectsGeneratorUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.MainActivity
import com.example.marketapplication.view.main.MainNavFragmentDirections
import com.example.marketapplication.view.main.adapters.sneakers.SneakersAdapter
import com.example.marketapplication.view.main.bottomsheet.BottomSheetFilterFragment
import com.example.marketapplication.view.main.sneakers.DescriptionSneakersFragment
import com.example.marketapplication.view.main.sneakers.DescriptionSneakersFragmentArgs
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SneakersFragment: BaseFragment<FragmentSneakersBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSneakersBinding
        get() = FragmentSneakersBinding::inflate


    private val bottomSheetDialog = BottomSheetFilterFragment()

    private lateinit var db: FirebaseFirestore
    private lateinit var sneakersAdapter: SneakersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sneakersAdapter = SneakersAdapter()
        binding.rvSneakers.adapter = sneakersAdapter
        db = Firebase.firestore

        sneakersAdapter.itemClickListener = { sneakers ->
            (requireActivity() as MainActivity).navigate(MainNavFragmentDirections.toDescriptionSneakersFragment(removeIsPossible =  false, sneakers = sneakers))
        }

        getSneakers()

        binding.imgFilter.setOnClickListener{
            showBottomSheetDialog()
        }

        bottomSheetDialog.filterCallback = { sneakersFilter ->
            val newSneakersList = sneakersAdapter.getItems().filter { sneakers ->
                sneakersFilter.name == sneakers.name && sneakersFilter.material == sneakers.material &&
                        sneakersFilter.size == sneakers.size && sneakersFilter.priceFrom == sneakers.price &&
                        sneakersFilter.priceTo == sneakers.price

            }
            sneakersAdapter.clearItems()
            sneakersAdapter.setItems(newSneakersList)
        }

    }

    private fun showBottomSheetDialog() {
        bottomSheetDialog.show(parentFragmentManager, BottomSheetFilterFragment.TAG)
    }

    private fun getSneakers() {
        db.collection("sneakers")
            .get()
            .addOnSuccessListener {
                val sneakersList = mutableListOf<Sneakers>()

                for (sneakersMap in it.documents) {
                    val name = sneakersMap["name"] as String
                    val size = sneakersMap["size"] as Long
                    val sizeType = sneakersMap["size_type"] as String
                    val material = sneakersMap["material"] as String
                    val length = sneakersMap["length"] as Long
                    val width = sneakersMap["width"] as Long
                    val price = sneakersMap["price"] as Long
                    val description = sneakersMap["description"] as String
                    val ownerId = sneakersMap["owner_id"] as String

                    val sneakers = Sneakers(ownerId = ownerId, name = name, size = size, sizeType = sizeType,
                        material = material, length = length, width = width ,price = price, description = description)
                    sneakersList.add(sneakers)
                }
                sneakersAdapter.setItems(sneakersList)
            }
            .addOnFailureListener { exception ->
                Log.w("SneakersFragment", "Error getting documents.", exception)
            }
    }
}