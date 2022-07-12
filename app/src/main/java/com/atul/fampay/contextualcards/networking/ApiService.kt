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
        const val ENDPOINT = "fefcfbeb-5c12-4722-94ad-b8f92caad1ad"
    }
}
