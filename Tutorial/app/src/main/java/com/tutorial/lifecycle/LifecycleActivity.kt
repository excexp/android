package com.tutorial.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorial.R

class LifecycleActivity : AppCompatActivity() {

    lateinit var chronometer: MyChronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        chronometer = findViewById(R.id.chronometer)
        lifecycle.addObserver(chronometer)
    }
}