package com.aibles.testgapoapi.data.repository

import com.aibles.testgapoapi.data.remote.NewsfeedService
import com.aibles.testgapoapi.data.remote.ServiceBuilder
import com.aibles.testgapoapi.domain.entity.DetailNews
import com.aibles.testgapoapi.domain.entity.ListNewsfeed
import retrofit2.Call
import retrofit2.Response

class NewsfeedRepositoryImpl {
    fun getNewsfeed(onResult: (isSuccess: Boolean, response: ListNewsfeed?) -> Unit) {

        val newsfeedService = ServiceBuilder.buildService(NewsfeedService::class.java)
        val requestCall = newsfeedService.getNewsfeed()

        requestCall.enqueue(object : retrofit2.Callback<ListNewsfeed> {
            override fun onResponse(call : Call<ListNewsfeed> , response: Response<ListNewsfeed>) {
                if (response.isSuccessful) {
                    onResult(true,response.body()!!)
                } else {
                    onResult(false,null)
                }
            }

            override fun onFailure(call: Call<ListNewsfeed>, t: Throwable) {
                onResult(false,null)
            }
        })
    }

    fun getDetailNews(onResult: (isSuccess: Boolean, response: DetailNews?) -> Unit) {
        ServiceBuilder.buildService(NewsfeedService::class.java)
            .getDetailNews()
            .enqueue(object : retrofit2.Callback<DetailNews> {
                override fun onResponse(call: Call<DetailNews>, response: Response<DetailNews>) {
                    if (response.isSuccessful) {
                        onResult(true, response.body()!!)
                    } else {
                        onResult(false,null)
                    }
                }

                override fun onFailure(call: Call<DetailNews>, t: Throwable) {
                    onResult(false, null)
                }
            })
    }

    companion object {
        private var INSTANCE: NewsfeedRepositoryImpl? = null
        fun getInstance() = INSTANCE
            ?: NewsfeedRepositoryImpl().also {
                INSTANCE = it
            }
    }

}