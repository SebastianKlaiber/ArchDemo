package de.sklaiber.archdemo

import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkText() {
        onView(withText("Hello world!")).check(matches(isDisplayed()))
    }
}