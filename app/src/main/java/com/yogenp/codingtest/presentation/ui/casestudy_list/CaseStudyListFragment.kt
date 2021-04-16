package com.yogenp.codingtest.presentation.ui.casestudy_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yogenp.codingtest.presentation.components.CaseStudyCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CaseStudyListFragment : Fragment() {

    private val viewModel: CaseStudyListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val caseStudies = viewModel.caseStudies.value

                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {
                        itemsIndexed(
                            items = caseStudies
                        ){ _, caseStudy ->
                            CaseStudyCard(caseStudy = caseStudy) {
                            }
                        }
                    }
                }
            }
        }
    }
}