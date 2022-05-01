package com.example.marketapplication.view.main.bottomnav

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.marketapplication.R
import com.example.marketapplication.databinding.FragmentNewSneakersBinding
import com.example.marketapplication.domain.storage.StoragePreference
import com.example.marketapplication.utils.ValidationUtils
import com.example.marketapplication.view.base.BaseFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NewSneakersFragment : BaseFragment<FragmentNewSneakersBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewSneakersBinding
        get() = FragmentNewSneakersBinding::inflate
    private lateinit var db: FirebaseFirestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = Firebase.firestore
        initSneakersSpinners()

        binding.tvSave.setOnClickListener {

            val isModelValid = ValidationUtils.validation(
                editText = binding.spModel,
                textInputLayout = binding.tilMaterial
            )
            val isMaterialValid = ValidationUtils.validation(
                editText = binding.spMaterial,
                textInputLayout = binding.tilMaterial
            )
            val isPriceValid = ValidationUtils.validation(
                editText = binding.tiEtPrice,
                textInputLayout = binding.tilPrice
            )
            val isDescriptionValid = ValidationUtils.validation(
                editText = binding.tiEtDescription,
                textInputLayout = binding.tilDescription
            )

            if (isDescriptionValid && isMaterialValid && isModelValid && isPriceValid) {
                makeSneakers()
            }
        }

    }


    private fun makeSneakers() {
        val name = binding.spModel.text.toString()
        val size = binding.spSizeNumber.selectedItem.toString().toInt()
        val sizeType = binding.spSizeType.selectedItem.toString()
        val material = binding.spMaterial.text.toString()
        val length = binding.spSizeLength.selectedItem.toString().toInt()
        val width = binding.spSizeWidth.selectedItem.toString().toInt()
        val description = binding.tiEtDescription.text.toString()
        val price = binding.tiEtPrice.text.toString().toInt()

        val storagePreference = StoragePreference(requireContext())
        val ownerId = storagePreference.userId()

        val newSneakersMap = hashMapOf(
            "owner_id" to ownerId,
            "name" to name,
            "size" to size,
            "size_type" to sizeType,
            "material" to material,
            "length" to length,
            "width" to width,
            "description" to description,
            "price" to price
        )

        db.collection("sneakers")
            .add(newSneakersMap)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    "CreateSneakers",
                    "DocumentSnapshot added with ID: ${documentReference.id}"
                )
                requireActivity().onBackPressed()
            }
            .addOnFailureListener { e ->
                Log.w("CreateSneakers", "Error adding documents", e)
            }
    }

    private fun initSneakersSpinners() {
        db.collection("sneakers_settings")
            .document("settings")
            .get()
            .addOnSuccessListener {
                val sizeTypeArray = it.data?.get("size_type") as ArrayList<*>
                binding.spSizeType.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item, sizeTypeArray
                )

                val lengthArray = it.data?.get("length") as ArrayList<*>
                binding.spSizeLength.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item, lengthArray
                )

                val widthArray = it.data?.get("width") as ArrayList<*>
                binding.spSizeWidth.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item, widthArray
                )

                val sneakersNamesArray = it.data?.get("sneakers_names") as ArrayList<*>
                binding.spModel.setAdapter(
                    ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_item, sneakersNamesArray
                    )
                )

                val materialArray = it.data?.get("material") as ArrayList<*>
                binding.spMaterial.setAdapter(
                    ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_item, materialArray
                    )
                )

                val sizeArray = it.data?.get("size") as ArrayList<*>
                val adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item, sizeArray
                )
                binding.spSizeNumber.adapter = adapter
            }
    }

}