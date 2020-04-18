package com.ctrl.demolivedata.basefragment

import android.os.Bundle
import android.view.View
import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.databinding.SecondFragmentBinding

class SecondFragment : BaseFragment<SecondFragmentBinding>() {

    override fun getFragmentView()= R.layout.second_fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.secondFragmentText.text="2nd Fragment"
    }


}