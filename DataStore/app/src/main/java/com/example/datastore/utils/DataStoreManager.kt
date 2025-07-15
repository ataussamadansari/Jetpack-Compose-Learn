package com.example.datastore.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.datastore.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Step 2.1: DataStore instance create karo (extension property)
val Context.dataStore by preferencesDataStore(name = "user_prefs")

class DataStoreManager(private val context: Context) {
    // Step 2.2: Keys define karo
    companion object {
        val NAME_KEY = stringPreferencesKey("name")
        val EMAIL_KEY = stringPreferencesKey("email")
        val PASSWORD_KEY = stringPreferencesKey("password")
        val LOGIN_KEY = booleanPreferencesKey("isLogin")
    }

    // Step 2.3: Data save karne ka function
    suspend fun saveUserData(name: String, email: String, password: String, isLogin: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[NAME_KEY] = name
            prefs[EMAIL_KEY] = email
            prefs[PASSWORD_KEY] = password
            prefs[LOGIN_KEY] = isLogin
        }
    }

    // Step 2.4: Data read karne ke flows
    val nameFlow: Flow<String?> = context.dataStore.data.map { it[NAME_KEY] }
    val emailFlow: Flow<String?> = context.dataStore.data.map { it[EMAIL_KEY] }
    val passwordFlow: Flow<String?> = context.dataStore.data.map { it[PASSWORD_KEY] }
    val isLoginFlow: Flow<Boolean> = context.dataStore.data.map { it[LOGIN_KEY] ?: false }


    val userDataFlow: Flow<UserData> = context.dataStore.data.map { pref ->
        val name = pref[NAME_KEY]
        val email = pref[EMAIL_KEY]
        val password = pref[PASSWORD_KEY]
        val isLogin = pref[LOGIN_KEY] ?: false

        UserData(name, email, password, isLogin)
    }

    // Step 2.5: Clear all data
    suspend fun clearAllData() {
        context.dataStore.edit { it.clear() }
    }
}