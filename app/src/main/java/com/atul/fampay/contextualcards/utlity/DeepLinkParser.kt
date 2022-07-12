package com.atul.fampay.contextualcards.utlity


import android.content.Intent
import android.net.Uri
import com.atul.fampay.contextualcards.MyApplication

/**
 * An object which handles all the deepLinks in the codebase,
 * it takes the Link as a string and creates a new [Intent]
 * obtaining the [Context] from [ContextualCardsApplication] to start the created [Intent]
 */
object DeepLinkParser {
    fun processDeepLink(deepLinkUrl: String): Boolean {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(deepLinkUrl)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        MyApplication.getContext().startActivity(intent)
        return true
    }
}
