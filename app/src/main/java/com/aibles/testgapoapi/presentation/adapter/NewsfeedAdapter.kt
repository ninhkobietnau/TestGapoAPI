package com.aibles.testgapoapi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aibles.testgapoapi.databinding.NewsfeedItemBinding
import com.aibles.testgapoapi.domain.entity.ListNewsfeed.Newsfeed
import com.aibles.testgapoapi.presentation.viewmodel.NewsfeedViewModel

class NewsfeedAdapter(
    private val newsfeedViewModel: NewsfeedViewModel
    ) :RecyclerView.Adapter<NewsfeedViewHolder>(){

    var newsfeedList: List<Newsfeed> = emptyList()

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsfeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = NewsfeedItemBinding.inflate(inflater, parent, false)
        return NewsfeedViewHolder(dataBinding, newsfeedViewModel)
    }

    override fun getItemCount(): Int {
        return newsfeedList.size
    }

    @Override
    override fun onBindViewHolder(holder: NewsfeedViewHolder, position: Int) {
        return holder.bind(newsfeedList[position])
    }

    fun updateListNewsfeed(newsfeed: List<Newsfeed>) {
        newsfeedList = newsfeed
        notifyDataSetChanged()
    }
}