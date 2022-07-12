package com.atul.fampay.contextualcards.models

import com.google.gson.annotations.SerializedName

data class Entity(
    val text: String,

    @SerializedName("font_style")
    val fontStyle: FontStyle?,

    val color: String? = null,
    val url: String? = null,

    @SerializedName("url_choice")
    val urlChoice: String? = null,

    @SerializedName("other_url")
    val otherUrl: String? = null
)

