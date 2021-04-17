package com.yogenp.codingtest.presentation.ui.casestudy

import androidx.lifecycle.ViewModel
import com.yogenp.codingtest.persistence.ThemePreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
* VideModel for Case study and its sections
* */
@HiltViewModel
class CaseStudyViewModel
@Inject
constructor(
    private val themePreferences: ThemePreferences
) : ViewModel(){

    suspend fun saveTheme(isDarkTheme: Boolean) {
        themePreferences.saveTheme(isDarkTheme)
    }
}