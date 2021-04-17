package com.yogenp.codingtest.presentation.ui.casestudy_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.persistence.ThemePreferences
import com.yogenp.codingtest.repository.CaseStudyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CaseStudyListViewModel
@Inject
constructor(
    private val repository: CaseStudyRepository,
    private val themePreferences: ThemePreferences
) : ViewModel() {

    val caseStudies: MutableState<List<CaseStudy>> = mutableStateOf(listOf())

    init {
        getFile()
    }

    private fun getFile() {
        viewModelScope.launch {
            val result = repository.get()
            caseStudies.value = result
        }
    }

    suspend fun saveTheme(isDarkTheme: Boolean) {
        themePreferences.saveTheme(isDarkTheme)
    }

}