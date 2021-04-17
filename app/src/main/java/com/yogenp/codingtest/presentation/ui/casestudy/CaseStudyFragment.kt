package com.yogenp.codingtest.presentation.ui.casestudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yogenp.codingtest.R
import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.presentation.BaseApplication
import com.yogenp.codingtest.presentation.components.SectionView
import com.yogenp.codingtest.presentation.components.TopToolbar
import com.yogenp.codingtest.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CaseStudyFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private var caseStudy: CaseStudy? = null
    private val viewModel: CaseStudyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme(darkTheme = application.isDark.value) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = 8.dp
                    ) {

                        caseStudy = application.caseStudy

                        Column {
                            TopToolbar(
                                text = caseStudy?.title ?: application.getString(R.string.app_name),
                                onClick = application::toggleDarkTheme
                            )

                            caseStudy?.let {
                                SectionView(caseStudy = it)
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