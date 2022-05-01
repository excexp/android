package com.tutorial.lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs),
    DefaultLifecycleObserver {

    companion object {
        var elapsedTime : Long = 0
    }

    override fun onResume(owner: LifecycleOwner) {
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()
    }

    override fun onPause(owner: LifecycleOwner) {
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }
}