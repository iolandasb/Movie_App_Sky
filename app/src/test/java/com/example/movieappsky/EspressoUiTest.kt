package com.example.movieappsky

import org.junit.Test
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movieappsky.presentation.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoUiTest {

    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)

//    @Test
//    fun start_search()  {
//        onView(withId(R.id.itSearch)).perform(click())
//        onView(withId(R.id.itSearch)).perform(typeText("Search"))
//        onView(withId(R.id.edtTitle)).perform(typeText("Sky Movies"))
//    }
}