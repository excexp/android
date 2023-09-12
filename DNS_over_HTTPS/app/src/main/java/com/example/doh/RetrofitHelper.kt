package com.example.doh

import android.util.Log
import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.dnsoverhttps.DnsOverHttps
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.net.InetAddress
import java.net.UnknownHostException


object RetrofitHelper {

    val baseUrl = "http://test.aitotem.cn/"


    fun getInstance(): Retrofit {

        val appCache = Cache(File("cacheDir", "okhttpcache"), 10 * 1024 * 1024)
        val bootstrapClient = OkHttpClient.Builder().cache(appCache).build()
//
//        val dns = DnsOverHttps.Builder().client(bootstrapClient)
//            .url("https://dns.totemtec.com/dns-query".toHttpUrl())
////            .bootstrapDnsHosts(InetAddress.getByName("49.233.245.5"), InetAddress.getByName("49.233.245.5"))
//            .build()

        val client = bootstrapClient.newBuilder().dns(MyDns()).build()

        return Retrofit.Builder().baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}