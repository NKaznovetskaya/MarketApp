package com.example.marketapplication.domain.storage

import android.content.Context
import android.content.SharedPreferences

class StoragePreference(context: Context) {

    companion object {
        const val USER_ID = "user_id"
    }

    private val preference: SharedPreferences = context.getSharedPreferences("market_app", Context.MODE_PRIVATE)

    fun saveUserId(id: String) {
        preference.edit().putString(USER_ID, id).apply()
    }

    fun userId(): String {
        return preference.getString(USER_ID, "")!!
    }

    fun removeUserId() {
        preference.edit().remove(USER_ID).apply()
    }

    fun isUserLoggedIn(): Boolean {
        return preference.getString(USER_ID, "")!!.isNotEmpty()
    }

}