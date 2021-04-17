package com.yogenp.codingtest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun app_launches() {
        composeTestRule.onNodeWithText(text = "Testing Tube brakes", substring = true)
            .assertIsDisplayed()
    }

    @Test
    fun app_openCaseStudies() {
        composeTestRule.onNodeWithText(text = "Testing Tube brakes", substring = true)
            .performClick()
        composeTestRule.onNodeWithText(text = "Reimagining brake testing", substring = true)
            .assertIsDisplayed()
    }
}