package com.ctrl.demolivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "======Owner create")
        lifecycle.addObserver(MainActivityObserver())
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "======Owner onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "======Owner Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "======Owner onpause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "======Owner stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "======Owner destroy")
    }


    companion object{
        private val TAG : String =MainActivity::class.java.simpleName
    }
}
