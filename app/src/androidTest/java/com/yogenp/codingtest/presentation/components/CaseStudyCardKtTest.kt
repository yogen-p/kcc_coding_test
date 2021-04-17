package com.yogenp.codingtest.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.yogenp.codingtest.presentation.MainActivity
import com.yogenp.codingtest.util.TEST_CASE_STUDY
import org.junit.Rule
import org.junit.Test


class CaseStudyCardKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun comp_loadList() {
        composeTestRule.setContent {
            CaseStudyCard(caseStudy = TEST_CASE_STUDY) {}
        }
        composeTestRule.onNodeWithText(text = "Hello World!", substring = true)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(text = "Hello World!", substring = true)
            .performClick()
        composeTestRule.onNodeWithContentDescription("Hero Image", ignoreCase = true)
            .assertIsDisplayed()
    }

}