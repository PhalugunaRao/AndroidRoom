package com.ctrl.demolivedata.basefragment

import android.os.Bundle
import android.view.View
import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.databinding.FirstFragmentBinding

class FirstFragment : BaseFragment<FirstFragmentBinding>() {
    override fun getFragmentView()=  R.layout.first_fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstFragmentText.text="1st Fragment"
    }
}