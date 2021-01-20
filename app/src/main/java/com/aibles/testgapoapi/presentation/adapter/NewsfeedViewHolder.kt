package com.aibles.testgapoapi.presentation.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.aibles.testgapoapi.domain.entity.ListNewsfeed.Newsfeed
import com.aibles.testgapoapi.presentation.viewmodel.NewsfeedViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.newsfeed_item.view.*

class NewsfeedViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val newsfeedViewModel: NewsfeedViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.iv_avatar
    val tvTitle = itemView.tvTitle
    val tvPublisher = itemView.textview_publisher
    val tvDate = itemView.textview_date

    fun bind(newsfeed: Newsfeed) {
        dataBinding.executePendingBindings()

        tvTitle.text = newsfeed.title
        tvPublisher.text = newsfeed.publisher.name
        tvDate.text = newsfeed.published_date

        if (!newsfeed.images.isNullOrEmpty()){
                Picasso.get().load(newsfeed.images[0].href).into(avatarImage)
        }

        itemView.setOnClickListener {
        }
    }
}