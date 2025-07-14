package com.example.todomaster.utils

import android.content.Context

object PrefsHelper {
    fun saveUser(context: Context, username: String) {
        val prefs = context.getSharedPreferences("todo_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("username", username).apply()
    }

    fun getUser(context: Context): String? {
        val prefs = context.getSharedPreferences("todo_prefs", Context.MODE_PRIVATE)
        return prefs.getString("username", null)
    }

    fun clearUser(context: Context) {
        context.getSharedPreferences("todo_prefs", Context.MODE_PRIVATE).edit().clear().apply()
    }
}
