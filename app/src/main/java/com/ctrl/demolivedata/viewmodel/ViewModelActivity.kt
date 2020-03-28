package com.ctrl.demolivedata.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ctrl.demolivedata.MainActivity
import com.ctrl.demolivedata.R
import kotlinx.android.synthetic.main.view_model_activity.*

class ViewModelActivity :AppCompatActivity() {
    lateinit var  data: MainActivityDataGenerator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_model_activity)
        //data = MainActivityDataGenerator()
        data =ViewModelProviders.of(this).get(MainActivityDataGenerator::class.java)
        val myRandomNumber = data.getNumber()

        myRandomNumber.observe(this,Observer<String> { number ->
            tvNumber.text = number
            Log.i(TAG, "===SET NUMBER")
        })
        bRandom.setOnClickListener {
            data.createNumber()
        }


    }



    companion object{
        private val TAG =MainActivity::class.simpleName
    }
}