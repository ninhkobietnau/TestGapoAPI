package com.aibles.testgapoapi.data.remote

import com.aibles.testgapoapi.domain.entity.ListNewsfeed
import retrofit2.Call
import retrofit2.http.GET

interface NewsfeedService {
    @GET("newsfeed.json")
    fun getNewsfeed() : Call<ListNewsfeed>
}