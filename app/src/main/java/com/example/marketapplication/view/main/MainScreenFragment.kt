package com.example.marketapplication.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketapplication.R


class MainScreenFragment : Fragment() {
    var sneakersAdapter: SneakersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sneakersAdapter = SneakersAdapter()
        val linearLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        val rvSneakers = requireActivity().findViewById<RecyclerView>(R.id.rvSneakers)
        rvSneakers.adapter = sneakersAdapter
        rvSneakers.layoutManager = linearLayoutManager

    }




}