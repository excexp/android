package com.example.doh

import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/hello.json")
    suspend fun sayHello() : Response<Result>
}