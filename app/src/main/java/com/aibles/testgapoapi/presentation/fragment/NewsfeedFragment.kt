package com.aibles.testgapoapi.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aibles.testgapoapi.R
import com.aibles.testgapoapi.data.remote.NewsfeedService
import com.aibles.testgapoapi.data.remote.ServiceBuilder
import com.aibles.testgapoapi.domain.entity.ListNewsfeed
import com.aibles.testgapoapi.domain.entity.ListNewsfeed.Newsfeed
import com.aibles.testgapoapi.presentation.adapter.NewsfeedAdapter
import kotlinx.android.synthetic.main.fragment_news_feed.*
import retrofit2.Call
import retrofit2.Response

class NewsfeedFragment : Fragment() {

    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadNewsfeed()
    }

    private fun loadNewsfeed () {
        val destinationService = ServiceBuilder.buildService(NewsfeedService::class.java)
        val requestCall = destinationService.getNewsfeed()

        requestCall.enqueue(object : retrofit2.Callback<ListNewsfeed> {
            override fun onResponse(call : Call<ListNewsfeed> , response: Response<ListNewsfeed>) {
                if (response.isSuccessful) {
//                    val newsfeedList = response.body()!!

                    newsfeed_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager =LinearLayoutManager(this.context)
                        adapter = response.body()?.let { NewsfeedAdapter(it.items) }
                    }
                } else {
                    Toast.makeText(context,"something went wrong ${response.message()}",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ListNewsfeed>, t: Throwable) {
                Toast.makeText(context,"something went wrong onFailure $t",Toast.LENGTH_LONG).show()
            }
        })
    }


}