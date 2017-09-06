package makingiants.com.uirobots

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainTestsWithoutRobot {

  @get:Rule
  var rule = ActivityTestRule(MainActivity::class.java, false, false)

  @Before
  fun setUp() {
    UserRepository.clear(InstrumentationRegistry.getTargetContext())

    rule.launchActivity(null)
  }

  @Test
  fun test_login_showMainView() {
    onView(withId(R.id.loginUsernameEditText))
        .perform(typeText("test@gmail.com"), closeSoftKeyboard())

    onView(withId(R.id.loginPasswordEditText))
        .perform(typeText("12345678"), closeSoftKeyboard())

    onView(withId(R.id.loginSubmitButton)).perform(click())

    onView(withText("Login"))
        .check(ViewAssertions.matches(isDisplayed()))
  }

  @Test
  fun test_onLogout_showLoginView() {
    onView(withId(R.id.loginUsernameEditText))
        .perform(typeText("test@gmail.com"), closeSoftKeyboard())

    onView(withId(R.id.loginPasswordEditText))
        .perform(typeText("12345678"), closeSoftKeyboard())

    onView(withId(R.id.loginSubmitButton))
        .perform(click())

    onView(withId(R.id.mainLogoutButton))
        .perform(click())

    onView(withText("Login"))
        .check(ViewAssertions.matches(isDisplayed()))
  }
}