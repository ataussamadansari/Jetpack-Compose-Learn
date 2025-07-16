package com.example.loginscreenjc.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.loginscreenjc.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore(name = "user_prefs")

class DataStoreManage(private val context: Context) {

    companion object {
        val USERNAME_KEY = stringPreferencesKey("username")
        val PASSWORD_KEY = stringPreferencesKey("password")
        val LOGIN_KEY = booleanPreferencesKey("isLogin")
    }

    suspend fun saveUserData(username: String, password: String, isLogin: Boolean) {
        context.dataStore.edit { pref ->
            pref[USERNAME_KEY] = username
            pref[PASSWORD_KEY] = password
            pref[LOGIN_KEY] = isLogin
        }
    }

    val isLoginFlow: Flow<Boolean> = context.dataStore.data.map {
        it[LOGIN_KEY] ?: false
    }

    val userdataFlow: Flow<UserData> = context.dataStore.data.map { pref ->
        val username = pref[USERNAME_KEY]
        val password = pref[PASSWORD_KEY]

        UserData(username, password)
    }

    suspend fun clearAllData() {
        context.dataStore.edit { it.clear() }
    }
}