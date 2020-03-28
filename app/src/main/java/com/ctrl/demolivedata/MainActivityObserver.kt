package com.ctrl.demolivedata

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivityObserver: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent(){
        Log.i(TAG, "===Observer Oncreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartEvent(){
        Log.i(TAG, "===Observer Start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent(){
        Log.i(TAG, "===Observer Pause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeEvent(){
        Log.i(TAG, "===Observer Resume")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopEvent(){
        Log.i(TAG, "===Observer Stop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestoryEvent(){
        Log.i(TAG, "===Observer Destroy")
    }


    companion object{
        private val TAG : String =MainActivityObserver::class.java.simpleName
    }
}