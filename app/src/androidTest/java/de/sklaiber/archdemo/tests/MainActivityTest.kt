package de.sklaiber.archdemo.tests

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import de.sklaiber.archdemo.R
import de.sklaiber.archdemo.ui.main.MainActivity
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.utils.RequestMatchers.pathContains
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setup() {
        RESTMockServer.reset()
    }

    @Test
    fun ipAdressShouldBeVisibleInTextView() {
        RESTMockServer.whenGET(pathContains("")).thenReturnFile("fixtures/ip.json")
        activityRule.launchActivity(null)
        onView(withId(R.id.ipAddressTv)).check(matches(withText("20.0.0.0"))).check(matches(isDisplayed()))
    }
}