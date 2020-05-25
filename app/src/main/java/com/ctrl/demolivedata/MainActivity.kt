package com.ctrl.demolivedata

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ctrl.demolivedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        //lifecycle.addObserver(MainActivityObserver())

        binding.check.setOnClickListener {
            val isInstalled: Boolean = isPackageInstalled(binding.textField.text.toString(), packageManager)
            if (isInstalled) // Install
            {
                val launchIntent =
                    packageManager.getLaunchIntentForPackage(binding.textField.text.toString())
                if (launchIntent != null) {
                    startActivity(launchIntent)
                }

            } else  // Not install
            {
                Toast.makeText(
                    applicationContext,
                    "Not Installed",
                    Toast.LENGTH_LONG).show()
            }
        }
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

    fun isAppInstalledOrNot(context: Context, applicationId: String): Boolean {
        try {
            println("===== ${applicationId}")
            context.packageManager.getPackageInfo(applicationId, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return false;
    }

    fun isPackageInstalled(
        packageName: String?,
        packageManager: PackageManager
    ): Boolean {
        return try {
            packageManager.getApplicationInfo(packageName, 0).enabled
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}
