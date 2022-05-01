package com.example.marketapplication.view.main.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.marketapplication.databinding.FragmentBottomSheetFilterBinding
import com.example.marketapplication.domain.model.SneakersFilter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class BottomSheetFilterFragment: BottomSheetDialogFragment() {

    val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBottomSheetFilterBinding
        get() = FragmentBottomSheetFilterBinding::inflate
    var binding: FragmentBottomSheetFilterBinding? = null
    lateinit var db: FirebaseFirestore

    var filterCallback: ((SneakersFilter) -> (Unit))? = null

    companion object {
        const val TAG = "BottomSheetFilterFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = Firebase.firestore

        db.collection("sneakers_settings")
            .document("settings")
            .get()
            .addOnSuccessListener {
                val materialArray = it.data?.get("material") as ArrayList<*>
                binding?.spMaterial?.setAdapter(ArrayAdapter(requireContext(),
                    android.R.layout.simple_spinner_item, materialArray))

                val sizeArray = it.data?.get("size") as ArrayList<*>
                binding?.spSizeFilter?.setAdapter(ArrayAdapter(requireContext(),
                    android.R.layout.simple_spinner_item, sizeArray))

                val modelArray = it.data?.get("sneakers_names") as ArrayList<*>
                binding?.ctvModel?.setAdapter(ArrayAdapter(requireContext(),
                    android.R.layout.simple_spinner_item, modelArray))

            }

        binding!!.tvApply.setOnClickListener {
            val name = binding!!.ctvModel.text.toString()
            val material = binding!!.spMaterial.text.toString()
            val size = binding!!.spSizeFilter.text.toString().toLong()
            val priceFrom = binding!!.tiEtPrice.text.toString().toLong()
            val priceTo = binding!!.tiEtPrice2.text.toString().toLong()

            val sneakersFilter = SneakersFilter(name = name, material = material, size = size,
                priceFrom = priceFrom, priceTo = priceTo)

            filterCallback?.invoke(sneakersFilter)
            dismiss()
        }

    }



}


