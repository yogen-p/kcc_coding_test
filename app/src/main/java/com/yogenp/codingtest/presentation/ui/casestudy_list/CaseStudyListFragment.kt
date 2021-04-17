package com.yogenp.codingtest.presentation.ui.casestudy_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yogenp.codingtest.R
import com.yogenp.codingtest.presentation.BaseApplication
import com.yogenp.codingtest.presentation.components.CaseStudyCard
import com.yogenp.codingtest.presentation.components.TopToolbar
import com.yogenp.codingtest.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* Fragment to show list of case studies
* */
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

                // To use Custom Theme
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
                                        CaseStudyCard(
                                            caseStudy = caseStudy,
                                            onClick = {
                                                application.caseStudy = caseStudy
                                                findNavController().navigate(R.id.goToCaseStudyFragment)
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        saveTheme()
    }

    override fun onStop() {
        super.onStop()
        saveTheme()
    }

    private fun saveTheme() {
        lifecycleScope.launch {
            viewModel.saveTheme(application.isDark.value)
        }
    }
}