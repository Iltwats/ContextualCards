package com.atul.fampay.contextualcards.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.atul.fampay.contextualcards.databinding.*
import com.atul.fampay.contextualcards.models.Card
import com.atul.fampay.contextualcards.models.CardGroup
import com.atul.fampay.contextualcards.utlity.SharedPreferenceUtils
import com.atul.fampay.contextualcards.views.viewholders.CardViewHolder

/**
 * Inflates & binds cardLayouts
 * It also takes care of itemView type and displaying the menu accordingly
 */
class CardsAdapter(private val designType: CardGroup.DesignType, private val groupId: Long) :
    RecyclerView.Adapter<CardViewHolder>() {
    private val TAG = "CardsAdapter"
    private val cardData = ArrayList<Card>()

    /** Sequenced on the basis of their HC values, increasing order, top to bottom */
    private lateinit var layoutSmallCardBinding: LayoutSmallCardBinding       // HC1
    private lateinit var layoutBigCardBinding: LayoutBigCardBinding           // HC3
    private lateinit var layoutImageCardBinding: LayoutImageCardBinding       // HC5
    private lateinit var layoutSmallCardWithArrowBinding: LayoutSmallCardWithArrowBinding // HC6
    private lateinit var layoutDynamicWidthCardBinding: LayoutDynamicWidthCardBinding // HC9

    private lateinit var layoutBigCardMenuBinding: LayoutBigCardMenuBinding

    /** Handling menu display for BigCard */
    private val SHOW_MENU = 1
    private val HIDE_MENU = 2

    /**
     * Initialize binding and inflate the layout depending upon the [DesignType] of the [CardGroup]
     * observed, one by one. without wasting resources
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)

        val binding: ViewBinding = when (designType) {
            CardGroup.DesignType.SMALL_DISPLAY_CARD -> {
                layoutSmallCardBinding = LayoutSmallCardBinding
                    .inflate(inflater, parent, false)
                layoutSmallCardBinding
            }

            CardGroup.DesignType.BIG_DISPLAY_CARD -> {
                if (viewType == SHOW_MENU) {
                    layoutBigCardMenuBinding = LayoutBigCardMenuBinding
                        .inflate(inflater, parent, false)
                    layoutBigCardMenuBinding
                } else {
                    layoutBigCardBinding = LayoutBigCardBinding
                        .inflate(inflater, parent, false)
                    layoutBigCardBinding
                }
            }

            CardGroup.DesignType.IMAGE_CARD -> {
                layoutImageCardBinding = LayoutImageCardBinding
                    .inflate(inflater, parent, false)
                layoutImageCardBinding
            }
            CardGroup.DesignType.SMALL_CARD_WITH_ARROW -> {
                layoutSmallCardWithArrowBinding = LayoutSmallCardWithArrowBinding
                    .inflate(inflater, parent, false)
                layoutSmallCardWithArrowBinding
            }

            CardGroup.DesignType.DYNAMIC_WIDTH_CARD -> {
                layoutDynamicWidthCardBinding = LayoutDynamicWidthCardBinding
                    .inflate(inflater, parent, false)
                layoutDynamicWidthCardBinding
            }
        }

        return CardViewHolder(binding)
    }

    /**
     * Bind those inflated layouts on the same ideology mentioned above
     */
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = cardData[position]
        with(cardItem) item@{
            with(holder) {
                when (designType) {
                    CardGroup.DesignType.SMALL_DISPLAY_CARD ->
                        SmallCardViewHolder(layoutSmallCardBinding)
                            .bindSmallCard(this@item)

                    CardGroup.DesignType.BIG_DISPLAY_CARD -> {
                        if (!cardItem.swipeMenu) {
                            BigCardViewHolder(layoutBigCardBinding).bindBigCard(this@item)
                            itemView.setOnLongClickListener {
                                showMenu(position)
                                true
                            }
                        } else {
                            with(layoutBigCardMenuBinding) {
                                menuRemindIcon.setOnClickListener { deleteCard(position + 1) }
                                menuDismissIcon.setOnClickListener { deleteCard(position + 1) }
                            }
                        }
                    }

                    CardGroup.DesignType.IMAGE_CARD ->
                        ImageCardViewHolder(layoutImageCardBinding)
                            .bindImageCard(this@item)

                    CardGroup.DesignType.SMALL_CARD_WITH_ARROW ->
                        SmallCardWithArrowViewHolder(layoutSmallCardWithArrowBinding)
                            .bindSmallCardWithArrow(this@item)

                    CardGroup.DesignType.DYNAMIC_WIDTH_CARD ->
                        DynamicWidthCardViewHolder(layoutDynamicWidthCardBinding)
                            .bindDynamicWidthCard(this@item)

                }
            }
        }
    }

    override fun getItemCount(): Int {
        return cardData.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (cardData[position].swipeMenu) SHOW_MENU else HIDE_MENU
    }

    fun setCardData(cardList: List<Card>) {
        cardData.clear()
        cardData.addAll(cardList)
        notifyDataSetChanged()
    }

    private fun showMenu(position: Int) {
        if (cardData.isNotEmpty() && !cardData[0].swipeMenu) {
            val menuCard = Card("menu_card")
            menuCard.swipeMenu = true
            cardData.add(position, menuCard)
            notifyDataSetChanged()
        }
    }

    fun hideMenu() {
        if (cardData.isNotEmpty() && cardData[0].swipeMenu) {
            cardData.removeAt(0)
            notifyDataSetChanged()
        }
    }

    private fun deleteCard(position: Int) {
        if (cardData.size > position) {
            cardData.removeAt(position)
            notifyDataSetChanged()
            SharedPreferenceUtils.addGroupId(groupId.toString())
        }
        hideMenu()
    }
}
