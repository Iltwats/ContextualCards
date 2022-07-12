package com.atul.fampay.contextualcards.utlity

import com.atul.fampay.contextualcards.utlity.DeepLinkParser.processDeepLink
import android.graphics.Color
import android.widget.Button
import com.atul.fampay.contextualcards.models.Cta

/**
 * An object containing an extension function on [Button] for Configuring [Cta] (Call To Action) on it,
 * the function is on button and takes a [Cta] and uses its properties to set the UI of button and
 * install link(s) in it (if available) to trigger the intended Action
 */
object CtaConfigurer {
    fun Button.configureCta(cta: Cta?) {
        cta?.let {
            apply {
                text = it.text
                setTextColor(Color.parseColor(it.textColor))
                setBackgroundColor(Color.parseColor(it.bgColor))
                setOnClickListener {
                    if (cta.otherUrl != null) {
                        processDeepLink(cta.otherUrl)
                    } else if (cta.url != null) {
                        processDeepLink(
                            cta.url
                        )
                    }
                }
            }
        }
    }
}
