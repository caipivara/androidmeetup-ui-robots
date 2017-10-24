package makingiants.com.uirobots

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import makingiants.com.uirobots.utils.CustomMatchers
import org.hamcrest.core.AllOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTestsPlain {

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

    Espresso.onView(AllOf.allOf(ViewMatchers.withText("Main")))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test
  fun test_login_withEmptyEmail_showsError() {
    Espresso.onView(ViewMatchers.withId(R.id.loginUsernameEditText))
        .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginPasswordEditText))
        .perform(ViewActions.typeText("12345678"), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginSubmitButton)).perform(ViewActions.click())

    Espresso.onView(ViewMatchers.withId(R.id.loginUsernameEditText))
        .check(ViewAssertions.matches(CustomMatchers.withError()))
  }

  @Test
  fun test_login_withEmptyPassword_showsError() {
    Espresso.onView(ViewMatchers.withId(R.id.loginUsernameEditText))
        .perform(ViewActions.typeText("test@gmail.com"), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginPasswordEditText))
        .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard())

    Espresso.onView(ViewMatchers.withId(R.id.loginSubmitButton)).perform(ViewActions.click())

    Espresso.onView(ViewMatchers.withId(R.id.loginPasswordEditText))
        .check(ViewAssertions.matches(CustomMatchers.withError()))
  }

}