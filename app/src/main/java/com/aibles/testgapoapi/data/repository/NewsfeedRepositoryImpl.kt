package com.aibles.testgapoapi.data.repository

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aibles.testgapoapi.data.remote.NewsfeedDataSource
import com.aibles.testgapoapi.data.remote.NewsfeedService
import com.aibles.testgapoapi.data.remote.ServiceBuilder
import com.aibles.testgapoapi.domain.entity.ListNewsfeed
import com.aibles.testgapoapi.presentation.adapter.NewsfeedAdapter
import kotlinx.android.synthetic.main.fragment_news_feed.*
import retrofit2.Call
import retrofit2.Response

class NewsfeedRepository{
    fun getNewsfeed(onResult: (isSuccess: Boolean, response: ListNewsfeed?) -> Unit) {
        val newsfeedService = ServiceBuilder.buildService(NewsfeedService::class.java)
        val requestCall = newsfeedService.getNewsfeed()

        requestCall.enqueue(object : retrofit2.Callback<ListNewsfeed> {
            override fun onResponse(call : Call<ListNewsfeed> , response: Response<ListNewsfeed>) {
                if (response.isSuccessful) {
//                    newsfeed_recycler.apply {
//                        setHasFixedSize(true)
//                        layoutManager = LinearLayoutManager(this.context)
//                        adapter = response.body()?.let { NewsfeedAdapter(it.items) }
//                    }
                    onResult(true,response.body()!!)
                } else {
                    onResult(false,null)
//                    Toast.makeText(context,"something went wrong ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ListNewsfeed>, t: Throwable) {
                onResult(false,null)
//                Toast.makeText(context,"something went wrong onFailure $t", Toast.LENGTH_LONG).show()
            }
        })
    }

    companion object {
        private var INSTANCE: NewsfeedRepository? = null
        fun getInstance() = INSTANCE
            ?: NewsfeedRepository().also {
                INSTANCE = it
            }
    }
}