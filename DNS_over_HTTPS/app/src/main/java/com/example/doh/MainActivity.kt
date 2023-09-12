package com.example.doh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var helloView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloView = findViewById(R.id.hello_message)

        testDnsOverHTTPS()
    }

    private fun testDnsOverHTTPS() {

        val api = RetrofitHelper.getInstance().create(Api::class.java)

        GlobalScope.launch {
            val response = api.sayHello()

            response.body()?.let {
                Log.e("RESPONSE MESSAGE", it.message)
            }

            withContext(Dispatchers.Main) {
                if (response != null) {
                    helloView.text = response.body()?.message
                }
            }
        }
    }
}