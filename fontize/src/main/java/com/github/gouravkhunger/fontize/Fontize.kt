/*
 * MIT License
 *
 * Copyright (c) 2021 Gourav Khunger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.gouravkhunger.fontize

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.lang.Exception
import java.util.*

class Fontize(private val context: Context) {

    private var preferenceName = "Preference"
    private lateinit var sharedPref: SharedPreferences

    private fun getMasterKey(): MasterKey? {
        try {
            val spec = KeyGenParameterSpec.Builder(
                "_androidx_security_master_key_",
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(256)
                .build()
            return MasterKey.Builder(context)
                .setKeyGenParameterSpec(spec)
                .build()
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, "Error on getting master key", e)
        }
        return null
    }

    private fun getEncryptedSharedPreferences(): SharedPreferences? {
        try {
            return getMasterKey()?.let {
                EncryptedSharedPreferences.create(
                    Objects.requireNonNull(context),
                    preferenceName,
                    it,  // calling the method above for creating MasterKey
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
            }
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, "Error on getting encrypted shared preferences", e)
        }
        return null
    }

    fun setDefaultFont(resourceId: Int) {
        sharedPref = getEncryptedSharedPreferences()!!
        val fontId = sharedPref.getInt("fontFamily", ResourcesCompat.ID_NULL)

        if (fontId == ResourcesCompat.ID_NULL) {
            sharedPref.edit()
                .putInt("fontFamily", resourceId)
                .apply()
        }
    }

    fun updateFont(resourceId: Int) {
        sharedPref = getEncryptedSharedPreferences()!!
        sharedPref.edit()
            .putInt("fontFamily", resourceId)
            .apply()
    }

    fun getStringPreference(key: String?): Int {
        return getEncryptedSharedPreferences()!!.getInt(key, ResourcesCompat.ID_NULL)
    }

}
