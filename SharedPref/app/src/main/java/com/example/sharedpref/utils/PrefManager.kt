package com.example.sharedpref.utils

import android.content.Context

class PrefManager(context: Context) {
    val sharedPref = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    val editor = sharedPref.edit()

    fun getUserData(name: String, email: String, password: String, isLogin: Boolean) {
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.putBoolean("isLogin", isLogin)
        editor.apply()
    }

    fun getUserData(): Map<String, Any?> {
        val name = sharedPref.getString("name", null)
        val email = sharedPref.getString("email", null)
        val password = sharedPref.getString("password", null)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        return mapOf(
            "name" to name,
            "email" to email,
            "password" to password,
            "isLogin" to isLogin
        )
    }

    fun isLogin(): Boolean {
        return sharedPref.getBoolean("isLogin", false)
    }

    fun clearAllData() {
        editor.clear()
        editor.apply()
    }
}