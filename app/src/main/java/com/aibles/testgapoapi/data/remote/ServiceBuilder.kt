package com.aibles.testgapoapi.data.remote

import com.aibles.testgapoapi.view.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val okHttp = OkHttpClient.Builder()

    private val builder = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService (serviceType :Class<T>) :T{
        return retrofit.create(serviceType)
    }
}