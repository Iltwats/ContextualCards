package com.atul.fampay.contextualcards.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.atul.fampay.contextualcards.databinding.LayoutCardGroupBinding

/**
 * A ViewHolder that exposes the recyclerView associated to it and part of adapter
 * (for displaying views in recyclerViews using adapters & ViewHolders)
 */
class CardGroupViewHolder(cardGroupBinding: LayoutCardGroupBinding) :
    RecyclerView.ViewHolder(cardGroupBinding.root) {
    val cardGroupRecyclerView = cardGroupBinding.rvCardGroup
}
