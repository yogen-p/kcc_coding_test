package com.yogenp.codingtest.presentation.ui.casestudy_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.network.responses.CaseStudyResponse
import com.yogenp.codingtest.repository.CaseStudyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CaseStudyListViewModel
@Inject
constructor(
    private val repository: CaseStudyRepository
): ViewModel(){

    val caseStudies: MutableState<List<CaseStudy>> = mutableStateOf(listOf())
    val loading = mutableStateOf(false)

    init {
        getFile()
    }

    fun getFile(){
        viewModelScope.launch {
            loading.value = true
            delay(2000)

            val result = repository.get()
            caseStudies.value = result

            loading.value = false
        }
    }

}