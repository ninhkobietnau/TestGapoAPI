package com.aibles.testgapoapi.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL = "https://raw.githubusercontent.com/Akaizz/static/master/"

    private val okHttp = OkHttpClient.Builder()

    private val builder = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService (serviceType :Class<T>) :T{
        return retrofit.create(serviceType)
    }
}