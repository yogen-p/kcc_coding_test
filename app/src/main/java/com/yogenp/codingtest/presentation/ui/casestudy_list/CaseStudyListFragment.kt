package com.yogenp.codingtest.presentation.ui.casestudy_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NightlightRound
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yogenp.codingtest.R
import com.yogenp.codingtest.presentation.BaseApplication
import com.yogenp.codingtest.presentation.components.CaseStudyCard
import com.yogenp.codingtest.presentation.components.TopToolbar
import com.yogenp.codingtest.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CaseStudyListFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: CaseStudyListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                AppTheme(darkTheme = application.isDark.value) {
                    val caseStudies = viewModel.caseStudies.value
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = 8.dp
                    ) {
                        Column {

                            TopToolbar(
                                text = application.getString(R.string.app_name),
                                onClick = application::toggleDarkTheme
                            )

                            Box(modifier = Modifier.fillMaxSize()) {
                                LazyColumn {
                                    itemsIndexed(
                                        items = caseStudies
                                    ) { _, caseStudy ->
                                        CaseStudyCard(caseStudy = caseStudy) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}