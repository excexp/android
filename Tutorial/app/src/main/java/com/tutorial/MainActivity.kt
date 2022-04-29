package com.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tutorial.lifecycle.LifecycleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun lifecycleDemo(view: View) {
        val intent = Intent(this, LifecycleActivity::class.java)
        startActivity(intent)
    }
}