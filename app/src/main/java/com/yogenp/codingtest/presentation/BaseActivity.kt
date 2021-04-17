package com.yogenp.codingtest.presentation

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import com.yogenp.codingtest.persistence.ThemePreferences
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@HiltAndroidApp
class BaseApplication : Application() {

    val isDark = mutableStateOf(false)

    override fun onCreate() {
        super.onCreate()
        MainScope().launch {
            val themePreferences = ThemePreferences(applicationContext)
            isDark.value = themePreferences.isDarkTheme.first()
        }
    }

    fun toggleDarkTheme() {
        isDark.value = !isDark.value
    }
}