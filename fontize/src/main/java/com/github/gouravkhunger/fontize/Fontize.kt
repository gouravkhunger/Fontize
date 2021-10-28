package com.github.gouravkhunger.fontize

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.res.ResourcesCompat
import androidx.preference.PreferenceManager

class Fontize(private val context: Context) {

    private lateinit var sharedPref: SharedPreferences

    fun setDefaultFont(resourceId: Int) {
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val fontId = sharedPref.getInt("fontFamily", ResourcesCompat.ID_NULL)

        if (fontId == ResourcesCompat.ID_NULL) {
            sharedPref.edit()
                .putInt("fontFamily", resourceId)
                .apply()
        }
    }

    fun updateFont(resourceId: Int) {
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPref.edit()
            .putInt("fontFamily", resourceId)
            .apply()
    }
}
