package com.github.gouravkhunger.fontize

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.preference.PreferenceManager

class FontizeView(
    context: Context,
    attrs: AttributeSet
) : AppCompatTextView(context, attrs) {
    init {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val fontId = prefs.getInt("fontFamily", ResourcesCompat.ID_NULL)
        if (fontId != ResourcesCompat.ID_NULL) {
            val typeface = ResourcesCompat.getFont(context, fontId)
            this.typeface = typeface
        }
    }
}
