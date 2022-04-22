package com.example.marketapplication.view.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.marketapplication.R
import com.example.marketapplication.databinding.FragmentMainNavBinding
import com.example.marketapplication.view.base.BaseFragment

class MainNavFragment: BaseFragment<FragmentMainNavBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainNavBinding
        get() = FragmentMainNavBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navBottomHostFragment = childFragmentManager.findFragmentById(R.id.nav_bottom_host_fragment) as NavHostFragment
        binding.navView.setupWithNavController(navBottomHostFragment.navController)



        binding.imgNewSneakers.setOnClickListener {
          val newSneakers = binding.imgNewSneakers
            (requireActivity() as MainActivity).navigate(MainNavFragmentDirections.toNewSneakersFragment())

        }
    }

}