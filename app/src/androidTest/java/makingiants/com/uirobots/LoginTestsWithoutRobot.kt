package makingiants.com.uirobots

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTestsWithoutRobot {

  @get:Rule
  var rule = ActivityTestRule(MainActivity::class.java, false, false)

  @Before
  fun setUp() {
    UserRepository.clear(InstrumentationRegistry.getTargetContext())

    rule.launchActivity(null)
  }

  @Test
  fun test_login_showMainView() {
    Espresso.onView(ViewMatchers.withId(R.id.loginUsernameEditText))
        .perform(ViewActions.typeText("test@gmail.com"), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginPasswordEditText))
        .perform(ViewActions.typeText("12345678"), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginSubmitButton)).perform(ViewActions.click())

    Espresso.onView(ViewMatchers.withText("Login"))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test
  fun test_onLogout_showLoginView() {
    Espresso.onView(ViewMatchers.withId(R.id.loginUsernameEditText))
        .perform(ViewActions.typeText("test@gmail.com"), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginPasswordEditText))
        .perform(ViewActions.typeText("12345678"), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginSubmitButton))
        .perform(ViewActions.click())

    Espresso.onView(ViewMatchers.withId(R.id.mainLogoutButton))
        .perform(ViewActions.click())

    Espresso.onView(ViewMatchers.withText("Login"))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }
}