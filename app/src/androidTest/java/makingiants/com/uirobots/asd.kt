package makingiants.com.uirobots

import android.app.Activity
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.view.View
import makingiants.com.uirobots.robots.BaseRobot
import makingiants.com.uirobots.robots.MainRobot
import makingiants.com.uirobots.utils.CustomMatchers
import org.hamcrest.Matchers

/**
 * Created by danielgomez22 on 9/6/17.
 */
class LoginRobot(activity: Activity) : BaseRobot(activity) {

  fun writeEmail(text: String): LoginRobot {
    Espresso.onView(ViewMatchers.withId(R.id.loginUsernameEditText))
        .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
    return this
  }

  fun writePassword(text: String): LoginRobot {
    Espresso.onView(ViewMatchers.withId(R.id.loginPasswordEditText))
        .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
    return this
  }

  fun clickLoginButton(): MainRobot {
    Espresso.onView(ViewMatchers.withId(R.id.loginSubmitButton))
        .perform(ViewActions.click())
    return MainRobot(activity)
  }

  fun checkIsVisible() {
    Matchers.allOf<View>(ViewMatchers.withText("Login"), ViewMatchers.isDisplayed())
  }

  fun checkEmailHaveError() {
    Espresso.onView(ViewMatchers.withId(R.id.loginUsernameEditText))
        .check(ViewAssertions.matches(CustomMatchers.withError()))
  }

  fun checkPasswordHaveError() {
    Espresso.onView(ViewMatchers.withId(R.id.loginPasswordEditText))
        .check(ViewAssertions.matches(CustomMatchers.withError()))
  }

}

