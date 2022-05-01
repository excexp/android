package com.tutorial

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class AppObserver: DefaultLifecycleObserver {
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("App", "onForeground")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("App", "onBackground")
    }
}