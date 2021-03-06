package com.atul.fampay.contextualcards.utlity

import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.atul.fampay.contextualcards.MyApplication

/**
 * SharedPreferences store for the application
 */
object SharedPreferenceUtils {

    private const val CONTEXTUAL_PREFS = "contextual_card_prefs"

    /**
     * Function used to save groupId locally using a [String] of Id(s) separated by commas[',']
     * which takes @param [groupId], the Id of a [CardGroup] that needs to be excluded
     */
    fun addGroupId(groupId: String) {
        lateinit var storedString: String
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext())
        if (preferences != null) {
            storedString = preferences.getString(CONTEXTUAL_PREFS, "").toString()
            storedString = storedString.plus(",").plus(groupId)
            preferences.edit { putString(CONTEXTUAL_PREFS, storedString) }
        }
    }

    /**
     * Functions to check if specific group needs to be excluded or not
     * which takes one parameter:
     * @param groupId a unique identifier of the group which may/(may not) be excluded
     * @return true if the group needs to be excluded, false otherwise
     */
    fun excludeCardGroup(groupId: String): Boolean {
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext())
        if (prefs != null) {
            val storedString = prefs.getString(CONTEXTUAL_PREFS, "")
            val stringList = storedString?.split(",")
            if (stringList != null) {
                for (id in stringList) {
                    if (id == groupId) return true
                }
            } else {
                return false
            }
        }
        return false
    }

}
