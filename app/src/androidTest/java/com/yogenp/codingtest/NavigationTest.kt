package com.yogenp.codingtest

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.test.espresso.Espresso
import com.yogenp.codingtest.presentation.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun app_launches() {
        assertEquals(getNavController().currentDestination?.id, R.id.caseStudyListFragment)
    }

    @Test
    fun profileScreen_back_conversationScreen() {
        val navController = getNavController()
        composeTestRule.runOnUiThread {
            navController.navigate(R.id.goToCaseStudyFragment)
        }

        assertEquals(navController.currentDestination?.id, R.id.caseStudyFragment)
        Espresso.pressBack()
        assertEquals(navController.currentDestination?.id, R.id.caseStudyListFragment)
    }

    private fun getNavController(): NavController {
        return composeTestRule.activity.findNavController(R.id.mainNavHostFragment)
    }
}