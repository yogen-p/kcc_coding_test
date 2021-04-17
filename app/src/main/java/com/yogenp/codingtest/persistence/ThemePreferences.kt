package com.yogenp.codingtest.persistence

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "theme_prefs")

class ThemePreferences(
    context: Context
) {

    private val applicationContext = context.applicationContext

    companion object {
        private val DARK_THEME = booleanPreferencesKey("dark_theme")
    }

    suspend fun saveTheme(isDarkTheme: Boolean) {
        applicationContext.dataStore.edit { themePref ->
            themePref[DARK_THEME] = isDarkTheme
        }
    }

    val isDarkTheme: Flow<Boolean> = applicationContext.dataStore.data
        .map { themePref ->
            themePref[DARK_THEME] ?: false
        }
}