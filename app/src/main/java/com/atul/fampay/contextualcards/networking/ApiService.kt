package com.atul.fampay.contextualcards.networking

import com.atul.fampay.contextualcards.models.CardGroupObject
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 * All the functions with their respective endpoints;
 */

interface ApiService {
    @GET(ENDPOINT)
    fun fetchCards(): Observable<CardGroupObject>

    companion object {
        const val ENDPOINT = "04a04703-5557-4c84-a127-8c55335bb3b4"
    }
}
