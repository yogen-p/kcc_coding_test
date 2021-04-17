package com.yogenp.codingtest

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.yogenp.codingtest.presentation.MainActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BasicTests {
    @get: Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.yogenp.codingtest", appContext.packageName)
    }

    @Test
    fun app_launches() {
        composeTestRule.onNodeWithText(text = "Testing Tube brakes", substring = true)
            .assertIsDisplayed()
    }

    @Test
    fun app_scrollsCaseStudies(){
        composeTestRule.onNodeWithText(text = "Testing Tube brakes", substring = true)
            .performGesture { swipeUp() }
    }

    @Test
    fun app_openCaseStudies() {
        composeTestRule.onNodeWithText(text = "Testing Tube brakes", substring = true)
            .performClick()
        composeTestRule.onNodeWithContentDescription("Hero Image", ignoreCase = true)
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "With 1.34 billion", substring = true, ignoreCase = true)
            .assertIsDisplayed()
    }

    @Test
    fun app_toggleTheme(){
        composeTestRule.onNodeWithContentDescription("Toggle theme").performClick()
    }
}