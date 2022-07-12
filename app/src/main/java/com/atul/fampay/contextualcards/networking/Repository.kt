package com.atul.fampay.contextualcards.networking

import com.atul.fampay.contextualcards.models.CardGroupObject
import io.reactivex.rxjava3.core.Observable

/**
 * All the communication between ViewModels and network happens through [Repository]
 */

class Repository {
    private val apiDelegate = ApiDelegate.instance

    /**
     * Calls the fetchCards() function defined in ApiService
     */
    fun fetchCardsData(): Observable<CardGroupObject> {
        return apiDelegate.apiService.fetchCards()
    }
}