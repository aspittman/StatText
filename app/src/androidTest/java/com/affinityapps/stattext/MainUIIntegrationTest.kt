package com.affinityapps.stattext

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.affinityapps.stattext.main.MainActivity
import org.junit.Before
import androidx.test.core.app.ActivityScenario.launch
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainUIIntegrationTest {
    
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test fun recyclerViewsResponseTest() {
        onView(withId(R.layout.activity_main))
        onView(withText("StatText")).check(matches(isDisplayed()))

        onView(withId(R.id.fragment_home)).perform(click())
        onView(withText("Bob")).check(matches(isDisplayed()))
        onView(withText("Bob")).perform(click())

        onView(withText("Saun")).check(matches(isDisplayed()))
        onView(withText("Saun")).perform(click())

        onView(withText("Dave")).check(matches(isDisplayed()))
        onView(withText("Dave")).perform(click())

        onView(withId(R.id.refresh_home)).perform(click())

        onView(withId(R.id.fragment_messages)).perform(click())
        onView(withText("Bob")).check(matches(isDisplayed()))
        onView(withText("Bob")).perform(click())

        onView(withText("Saun")).check(matches(isDisplayed()))
        onView(withText("Saun")).perform(click())

        onView(withText("Dave")).check(matches(isDisplayed()))
        onView(withText("Dave")).perform(click())

        onView(withId(R.id.refresh_home)).perform(click())
    }

    @Test fun mainUIResponseTest() {
        onView(withId(R.layout.activity_main))
        onView(withText("StatText")).check(matches(isDisplayed()))

        //home recyclerview ui response test
        onView(withId(R.id.fragment_home)).perform(click())
        onView(withText("Bob")).check(matches(isDisplayed()))
        onView(withText("Bob")).perform(click())

        onView(withId(R.id.fragment_statistics)).perform(click())
        onView(withText("statisticsTest")).check(matches(isDisplayed()))

        onView(withId(R.id.fragment_summary)).perform(click())
        onView(withText("summaryTest")).check(matches(isDisplayed()))

        onView(withId(R.id.fragment_messages)).perform(click())
        onView(withText("laaaaaaa")).check(matches(isDisplayed()))

        //Second row UI navigation test
        onView(withId(R.id.fragment_home)).perform(click())
        onView(withText("Saun")).check(matches(isDisplayed()))
        onView(withText("Saun")).perform(click())

        onView(withId(R.id.fragment_statistics)).perform(click())
        onView(withText("statisticsTest")).check(matches(isDisplayed()))

        onView(withId(R.id.fragment_summary)).perform(click())
        onView(withText("summaryTest")).check(matches(isDisplayed()))

        onView(withId(R.id.fragment_messages)).perform(click())
        onView(withText("laaaaaaa")).check(matches(isDisplayed()))

        //third row UI navigation test
        onView(withId(R.id.fragment_home)).perform(click())
        onView(withText("Dave")).check(matches(isDisplayed()))
        onView(withText("Dave")).perform(click())

        onView(withId(R.id.fragment_statistics)).perform(click())
        onView(withText("statisticsTest")).check(matches(isDisplayed()))

        onView(withId(R.id.fragment_summary)).perform(click())
        onView(withText("summaryTest")).check(matches(isDisplayed()))

        onView(withId(R.id.fragment_messages)).perform(click())
        onView(withText("laaaaaaa")).check(matches(isDisplayed()))

        //toolbar menu icons
        onView(withId(R.id.light_dark)).perform(click())
        onView(withId(R.id.light_dark)).perform(click())
        onView(withId(R.id.add_permissions)).perform(click())
    }
}