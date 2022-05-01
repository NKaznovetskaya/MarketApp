package com.example.marketapplication.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentPasswordBinding
import com.example.marketapplication.domain.storage.StoragePreference
import com.example.marketapplication.utils.ValidationUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.MainActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PasswordFragment : BaseFragment<FragmentPasswordBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPasswordBinding
        get() = FragmentPasswordBinding::inflate

    var usersList: List<DocumentSnapshot>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val phone = PasswordFragmentArgs.fromBundle(requireArguments()).phone

        FirebaseApp.initializeApp(requireContext())
        val db = Firebase.firestore

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                usersList = result.documents

                for (document in result) {
                    Log.d("Verification", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Verification", "Error getting documents.", exception)
            }


        binding.btnNext.setOnClickListener {

            val isPasswordValid = ValidationUtils.validation(
                textInputLayout = binding.tilPassword,
                editText = binding.etPassword
            )
            if (isPasswordValid) {
                val password = binding.etPassword.text.toString()
                var isUserRegistered = false
                if (usersList != null) {
                    for (user in usersList!!) {
                        val userData = user.data
                        val userPhone = userData?.get("phone") as String
                        val userPassword = userData["password"] as String

                        if (userPassword == password && userPhone == phone) {
                            isUserRegistered = true

                            val storage = StoragePreference(requireContext())
                            storage.saveUserId(user.id)

                            val intent = Intent(requireContext(), MainActivity::class.java)
                            startActivity(intent)
                            requireActivity().finish()
                        }
                    }
                }

                if (!isUserRegistered) {
                    (requireActivity() as LoginActivity).navigate(
                        PasswordFragmentDirections.toDataFragment(
                            phone,
                            password
                        )
                    )
                }
            }
        }
    }

}