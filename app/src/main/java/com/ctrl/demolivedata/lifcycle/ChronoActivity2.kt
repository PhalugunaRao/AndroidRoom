package com.ctrl.demolivedata.lifcycle

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.ctrl.demolivedata.R


class ChronoActivity2: AppCompatActivity() {

    private lateinit var chronometerViewModel: ChronometerViewModel
    private var chronometer :Chronometer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_test)
        chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)
        chronometer= findViewById(R.id.chronometer)

        if (chronometerViewModel.getStartTime() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            val startTime = SystemClock.elapsedRealtime()
            chronometerViewModel.setStartTime(startTime)
            chronometer?.setBase(startTime)
        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            chronometer?.setBase(chronometerViewModel.getStartTime()!!)
        }

        chronometer?.start()
    }

}