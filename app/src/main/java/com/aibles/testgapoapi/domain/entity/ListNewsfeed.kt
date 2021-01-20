package com.aibles.testgapoapi.domain.entity

import com.google.gson.annotations.SerializedName

data class ListNewsfeed(
    @SerializedName("items")
    val items: List<Newsfeed>
){
    data class Newsfeed(
        val avatar: Avatar,
        val content: Content,
        val content_type: String,
        val description: String,
        val document_id: String,
        val images: List<Image>,
        val origin_url: String,
        val published_date: String,
        val publisher: Publisher,
        val title: String
    ) {
        data class Avatar(
            val height: Int,
            val href: String,
            val main_color: String,
            val width: Int
        )

        data class Content(
            val duration: Int,
            val href: String,
            val preview_image: PreviewImage
        ) {
            data class PreviewImage(
                val height: Int,
                val href: String,
                val main_color: String,
                val width: Int
            )
        }

        data class Image(
            val height: Int,
            val href: String,
            val main_color: String,
            val width: Int
        )

        data class Publisher(
            val icon: String,
            val id: String,
            val name: String
        )
    }
}

