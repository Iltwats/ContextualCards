package com.atul.fampay.contextualcards.models

import com.google.gson.annotations.SerializedName

data class Gradient (
    @SerializedName("colors")
    val colorList: List<String>,

    val angle: Double
)
