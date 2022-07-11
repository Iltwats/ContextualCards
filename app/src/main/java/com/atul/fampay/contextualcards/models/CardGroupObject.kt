package com.atul.fampay.contextualcards.models

import com.google.gson.annotations.SerializedName

/**
 * This class is to parse the `card_groups` object returned from
 * the API response which contains a List of [CardGroup]
 */

data class CardGroupObject(
    @SerializedName("card_groups")
    val cardGroup: List<CardGroup>
)
