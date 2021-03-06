package com.example.marketapplication.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.marketapplication.databinding.FragmentDataBinding
import com.example.marketapplication.domain.storage.StoragePreference
import com.example.marketapplication.utils.ValidationUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DataFragment : BaseFragment<FragmentDataBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDataBinding
        get() = FragmentDataBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FirebaseApp.initializeApp(requireContext())
        val db = Firebase.firestore

        binding.btnDone.setOnClickListener {

            val isFirstNameValid = ValidationUtils.validation(editText = binding.etFirstName, textInputLayout = binding.tilFirstName)
            val isSecondNameValid = ValidationUtils.validation(editText = binding.etLastName, textInputLayout = binding.tilLastName)
            val isCityValid = ValidationUtils.validation(editText = binding.etCity, textInputLayout = binding.tilCity)

            if (isFirstNameValid && isSecondNameValid && isCityValid) {
                val phone = DataFragmentArgs.fromBundle(requireArguments()).phone
                val password = DataFragmentArgs.fromBundle(requireArguments()).password
                val firstName = binding.etFirstName.text.toString()
                val lastName = binding.etLastName.text.toString()
                val city = binding.etCity.text.toString()

                val userMap = hashMapOf(
                    "first_name" to firstName, "last_name" to lastName,
                    "phone" to phone, "city" to city, "password" to password
                )

                db.collection("users")
                    .add(userMap)
                    .addOnSuccessListener { documentReference ->
                        Log.d(
                            "CreateUser",
                            "DocumentSnapshot added with ID: ${documentReference.id}"
                        )

                        val storage = StoragePreference(requireContext())
                        storage.saveUserId(documentReference.id)

                        val intent = Intent(requireContext(), MainActivity::class.java)
                        startActivity(intent)
                    }
                    .addOnFailureListener { e ->
                        Log.w("CreateUser", "Error adding document", e)
                    }
            }

        }


    }


}

