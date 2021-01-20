package com.aibles.testgapoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aibles.testgapoapi.data.remote.NewsfeedService
import com.aibles.testgapoapi.data.remote.ServiceBuilder
import com.aibles.testgapoapi.presentation.adapter.NewsfeedAdapter
import kotlinx.android.synthetic.main.fragment_news_feed.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}