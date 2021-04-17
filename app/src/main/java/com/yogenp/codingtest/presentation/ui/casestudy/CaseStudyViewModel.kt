package com.yogenp.codingtest.presentation.ui.casestudy

import androidx.lifecycle.ViewModel
import com.yogenp.codingtest.persistence.ThemePreferences
import com.yogenp.codingtest.repository.CaseStudyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

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