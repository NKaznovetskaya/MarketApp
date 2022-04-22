package com.example.marketapplication.view.main.bottomnav

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentSettingsBinding
import com.example.marketapplication.domain.storage.StoragePreference
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.login.LoginActivity
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding
        get() = FragmentSettingsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = Firebase.firestore

        val storage = StoragePreference(requireContext())
        val userId = storage.userId()
        val userDocRef = db.collection("users").document(userId)

        // Source can be CACHE, SERVER, or DEFAULT.
        val source = Source.CACHE

        // Get the document, forcing the SDK to use the offline cache
        userDocRef.get(source).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Document found in the offline cache
                val userDoc = task.result
                val userData = userDoc?.data

                val phone = userData?.get("phone") as String
                val city = userData["city"] as String
                val firstName = userData["first_name"] as String
                val lastName = userData["last_name"] as String

                binding.tvNameUser.text = "$firstName $lastName"
                binding.tiEtContact.setText(phone)
                binding.tiEtCity.setText(city)

                Log.d("Settings", "Cached document data: ${userDoc?.data}")
            } else {
                Log.d("Settings", "Cached get failed: ", task.exception)
            }
        }

        binding.btnExit.setOnClickListener {
            val storagePreference = StoragePreference(requireContext())
            storagePreference.removeUserId()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}