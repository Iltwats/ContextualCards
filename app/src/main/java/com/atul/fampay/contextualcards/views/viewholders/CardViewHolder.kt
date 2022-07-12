package com.atul.fampay.contextualcards.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.atul.fampay.contextualcards.databinding.*
import com.atul.fampay.contextualcards.models.Card
import com.atul.fampay.contextualcards.utlity.CtaConfigurer.configureCta
import com.atul.fampay.contextualcards.utlity.DeepLinkParser.processDeepLink
import com.atul.fampay.contextualcards.utlity.ImageLoader.loadImage
import com.atul.fampay.contextualcards.utlity.TextFormatter.format

/**
 * A parent ViewHolder that contains the API for binding of Views/Layouts([Card]s)
 * It contains many ViewHolders for each specific [DesignType] of Card, each of which takes
 * a viewBinding as a parameter to ease referring to the layouts and also produces cleaner & readable API
 */
class CardViewHolder(viewBinding: ViewBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    inner class SmallCardViewHolder(
        private val smallCardBinding: LayoutSmallCardBinding
        ) {
        fun bindSmallCard(card: Card) {
            with(smallCardBinding) {
                with(card) {
                    smallCardTitle.format(formattedTitle, title)
                    smallCardDescription.format(formattedDescription, description)
                    icon?.imgUrl?.let { smallCardIcon.loadImage(it) }
                    url?.let {
                        smallCardView.setOnClickListener {
                            processDeepLink(this.url)
                        }
                    }
                }
            }
        }
    }

    inner class ImageCardViewHolder(
        private val imageCardBinding: LayoutImageCardBinding
        ) {
        fun bindImageCard(card: Card) {
            with(imageCardBinding) {
                with(card) {
                    bgImage?.imgUrl?.let { imageCardImage.loadImage(it) }
                    url?.let {
                        imageCard.setOnClickListener { processDeepLink(url) }
                    }
                }
            }
        }
    }

    inner class BigCardViewHolder(
        private val bigCardBinding: LayoutBigCardBinding
        ) {
        fun bindBigCard(card: Card) {
            with(bigCardBinding) {
                with(card) {
                    tvTitle.format(formattedTitle, title)
                    tvDescription.format(formattedDescription, description)
                    ctaList?.let { buttonAction.configureCta(it[0]) }
                    bgImage?.imgUrl?.let { imageBigCard.loadImage(it, true) }
                    url?.let {
                        bigCardView.setOnClickListener {
                            processDeepLink(url)
                        }
                    }
                }
            }
        }
    }

    inner class SmallCardWithArrowViewHolder(
        private val layoutSmallCardWithArrowBinding: LayoutSmallCardWithArrowBinding
        ) {
        fun bindSmallCardWithArrow(card: Card) {
            with(layoutSmallCardWithArrowBinding) {
                with(card) {
                    smallCardWithArrowTitle.format(formattedTitle, title)
                    icon?.imgUrl?.let { smallCardWithArrowImage.loadImage(it) }
                    url?.let {
                        smallCardWithArrowView.setOnClickListener {
                            processDeepLink(url)
                        }
                    }
                }
            }
        }
    }

    inner class DynamicWidthCardViewHolder(
        private val layoutDynamicWidthCardBinding: LayoutDynamicWidthCardBinding
        ) {
        fun bindDynamicWidthCard(card: Card) {
            with(layoutDynamicWidthCardBinding) {
                with(card) {
                    bgImage?.imgUrl?.let { dynamicWidthCardImageView.loadImage(it) }
                    url?.let { dynamicWidthCardView.setOnClickListener { processDeepLink(url) } }
                }
            }
        }
    }
}
