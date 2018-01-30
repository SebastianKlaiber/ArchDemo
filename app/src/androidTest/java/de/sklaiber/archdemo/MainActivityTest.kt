package de.sklaiber.archdemo

import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import de.sklaiber.archdemo.api.model.IpAddress
import de.sklaiber.archdemo.repository.Repository
import de.sklaiber.archdemo.ui.main.MainActivity
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Mock
    private lateinit var mockRepository: Repository

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkText() {
        Mockito.`when`(mockRepository.getDataFromApi()).thenReturn(Single.just(IpAddress("20.0.0.0")))
        onView(withText("20.0.0.0")).check(matches(isDisplayed()))
    }
}