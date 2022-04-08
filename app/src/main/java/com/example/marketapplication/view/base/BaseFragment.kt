package com.example.marketapplication.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.IllegalStateException

abstract class BaseFragment<B : ViewBinding>: Fragment() {

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> B
    var mBinding: B? = null
    val binding: B
        get() {
            if (mBinding == null) throw IllegalStateException("Binding not found")
            return mBinding as B
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = bindingInflater.invoke(inflater, container, false)
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }


}