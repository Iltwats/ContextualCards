package com.atul.fampay.contextualcards.utlity

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import com.atul.fampay.contextualcards.models.FontStyle
import com.atul.fampay.contextualcards.models.FormattedText


object TextFormatter {
    /**
     * An extension function on a [TextView] which takes
     * @param [formattedText] which comprises of [Entities] which contain properties
     * that are supposed to be used for formatting the text to be rendered on screen
     * as a [TextView].
     */
    fun format(formattedText: FormattedText?, fallbackText: String): CharSequence {
        if (formattedText == null) return fallbackText

        val text = " ${formattedText.text} "
        val splitStrings = text.split("{}")
        val spannableBuilder = SpannableStringBuilder()
        var spanStart = -1

        splitStrings.forEachIndexed { i, s ->
            if (spanStart == -1) {
                spanStart = 0
            } else {
                val entity = formattedText.entityList[i - 1]
                spannableBuilder.append(entity.text)
                val start = spanStart
                val end = spanStart + entity.text.length

                entity.color?.let {
                    spannableBuilder.setSpan(
                        ForegroundColorSpan(Color.parseColor(it)),
                        start,
                        end,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

                entity.fontStyle?.let {
                    val span = when (it) {
                        FontStyle.UNDERLINE -> UnderlineSpan()
                        FontStyle.ITALICS -> StyleSpan(Typeface.ITALIC)
                        FontStyle.BOLD -> StyleSpan(Typeface.BOLD)
                    }

                    spannableBuilder.setSpan(
                        span, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

                entity.url?.let {
                    spannableBuilder.setSpan(
                        URLSpan(it), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
                spanStart += entity.text.length
            }
            spannableBuilder.append(s)

            spanStart += s.length
        }

        return spannableBuilder.trim()
    }
}
