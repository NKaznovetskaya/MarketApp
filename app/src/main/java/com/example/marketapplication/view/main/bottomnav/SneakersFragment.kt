package com.example.marketapplication.view.main.bottomnav

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marketapplication.databinding.FragmentSneakersBinding
import com.example.marketapplication.utils.ObjectsGeneratorUtils
import com.example.marketapplication.view.base.BaseFragment
import com.example.marketapplication.view.main.MainActivity
import com.example.marketapplication.view.main.MainNavFragmentDirections
import com.example.marketapplication.view.main.adapters.sneakers.SneakersAdapter
import com.example.marketapplication.view.main.bottomsheet.BottomSheetFilterFragment

class SneakersFragment: BaseFragment<FragmentSneakersBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSneakersBinding
        get() = FragmentSneakersBinding::inflate

    private val bottomSheetDialog = BottomSheetFilterFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.e("LifeCycle", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sneakersAdapter = SneakersAdapter()
        binding.rvSneakers.adapter = sneakersAdapter
        sneakersAdapter.setItems(ObjectsGeneratorUtils.sneakersList())

        sneakersAdapter.itemClickListener = {
            (requireActivity() as MainActivity).navigate(MainNavFragmentDirections.toDescriptionSneakersFragment(false))
        }

        binding.imgFilter.setOnClickListener{
            showBottomSheetDialog()
        }

    }

    private fun showBottomSheetDialog() {
        bottomSheetDialog.show(parentFragmentManager, BottomSheetFilterFragment.TAG)
    }


}