package com.fury.flickerapp.base.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(container?.context), layoutResId, container, false)
        onFragmentReady(savedInstanceState, rootView as B)
        return rootView.root

    }

    @get:LayoutRes
    protected abstract val layoutResId: Int

    protected abstract fun onFragmentReady(instanceState: Bundle?, binding: B)

}