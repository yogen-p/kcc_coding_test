package com.yogenp.codingtest.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.yogenp.codingtest.presentation.MainActivity
import com.yogenp.codingtest.util.TEST_CASE_STUDY
import org.junit.Rule
import org.junit.Test

/*
* For SectionView composable for list of sections
* */
class SectionViewKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun comp_loadSections() {
        composeTestRule.setContent {
            SectionView(caseStudy = TEST_CASE_STUDY)
        }
        // Fragment 2
        composeTestRule.onNodeWithContentDescription("Hero Image", ignoreCase = true)
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "Hello1", substring = true, ignoreCase = true)
            .assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Section Image", ignoreCase = true)
            .assertIsDisplayed()

    }
}