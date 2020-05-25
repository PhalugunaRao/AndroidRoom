package com.ctrl.demolivedata.note.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.databinding.SampleMainBinding

class SampleMainActivity:AppCompatActivity() {
    lateinit var binding: SampleMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.sample_main)

        val navController= Navigation.findNavController(this,R.id.fragment3)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this,R.id.fragment3),
            null
        )
    }
}