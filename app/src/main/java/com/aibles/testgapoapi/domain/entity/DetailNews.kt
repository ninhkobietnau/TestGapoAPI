package com.aibles.testgapoapi.domain.entity

data class DetailNews(
    val description: String,
    val document_id: String,
    val origin_url: String,
    val published_date: String,
    val publisher: Publisher,
    val sections: List<Section>,
    val template_type: String,
    val title: String
) {
    data class Publisher(
        val icon: String,
        val id: String,
        val name: String
    )

    data class Section(
        val content: Content,
        val section_type: Int
    ) {
        data class Content(
            val caption: String,
            val duration: Int,
            val href: String,
            val main_color: String,
            val markups: List<Markup>,
            val original_height: Int,
            val original_width: Int,
            val preview_image: PreviewImage,
            val text: String
        ) {
            data class Markup(
                val end: Int,
                val href: String,
                val markup_type: Int,
                val start: Int
            )

            data class PreviewImage(
                val height: Int,
                val href: String,
                val main_color: String,
                val width: Int
            )
        }
    }
}