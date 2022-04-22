package com.example.marketapplication.view.main.bottomnav

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentNewSneakersBinding
import com.example.marketapplication.domain.storage.StoragePreference
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.MainActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NewSneakersFragment : BaseFragment<FragmentNewSneakersBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewSneakersBinding
        get() = FragmentNewSneakersBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FirebaseApp.initializeApp(requireContext())
        val db = Firebase.firestore

        binding.tvSave.setOnClickListener {
            val name = binding.tiEtModel.text.toString()
            val size = binding.tvSizeNumber.text.toString().toInt()
            val sizeType = binding.tvSizeType.text.toString()
            val material = binding.tiEtMaterial.text.toString()
            val length = binding.tvSizeLength.text.toString().toInt()
            val width = binding.tvSizeWidth.text.toString().toInt()
            val description = binding.tiEtDescription.text.toString()
            val price = binding.tiEtPrice.text.toString().toInt()

            val storagePreference = StoragePreference(requireContext())
            val ownerId = storagePreference.userId()

            val newSneakersMap = hashMapOf("owner_id" to ownerId, "name" to name, "size" to size, "size_type" to sizeType,
                "material" to material, "length" to length, "width" to width, "description" to description,
                "price" to price)

            db.collection("sneakers")
                .add(newSneakersMap)
                .addOnSuccessListener { documentReference ->
                    Log.d("CreateSneakers","DocumentSnapshot added with ID: ${documentReference.id}")
                    requireActivity().onBackPressed()
                }
                .addOnFailureListener { e ->
                    Log.w("CreateSneakers", "Error adding documents", e )
                }
        }
    }

}