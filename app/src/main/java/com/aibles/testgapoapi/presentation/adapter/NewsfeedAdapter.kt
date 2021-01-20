package com.aibles.testgapoapi.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aibles.testgapoapi.R
import com.aibles.testgapoapi.domain.entity.ListNewsfeed
import com.aibles.testgapoapi.domain.entity.ListNewsfeed.Newsfeed

class NewsfeedAdapter(
    private val newsfeedList: List<Newsfeed>
    ) :RecyclerView.Adapter<NewsfeedAdapter.ViewHolder>(){

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newsfeed_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsfeedList.size
    }

    @Override
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(newsfeedList[position])
    }

    class ViewHolder (items : View) :RecyclerView.ViewHolder(items) {
        var tvTitle = items.findViewById<TextView>(R.id.tvTitle)
        var tvContentType = items.findViewById<TextView>(R.id.tvContentType)
        fun bind (newsfeed: Newsfeed) {
            tvContentType.text = newsfeed.content_type
            tvTitle.text = newsfeed.title
        }
    }
}