package com.ctrl.demolivedata.lifcycle

import androidx.lifecycle.ViewModel

class ChronometerViewModel : ViewModel() {
    private var mStartTime: Long? = null

    fun getStartTime(): Long? {
        return mStartTime
    }

    fun setStartTime(startTime: Long) {
        mStartTime = startTime
    }


}