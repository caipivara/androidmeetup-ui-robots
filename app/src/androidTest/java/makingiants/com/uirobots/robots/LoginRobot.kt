package makingiants.com.uirobots.robots

import android.app.Activity
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.view.View
import makingiants.com.uirobots.R
import makingiants.com.uirobots.utils.CustomMatchers
import org.hamcrest.Matchers

class LoginRobot(activity: Activity) : BaseRobot(activity) {

  fun doLoginSuccessfully(): MainRobot {
    writeEmail("daniel+p@barista-v.com")
    writePassword("12345678")

    clickLoginButton()

    return MainRobot(activity)
  }

  fun writeEmail(text: String): LoginRobot {
    write(R.id.loginUsernameEditText, text)
    return this
  }

  fun writePassword(text: String): LoginRobot {
    write(R.id.loginPasswordEditText, text)
    return this
  }

  fun clickLoginButton(): MainRobot {
    click(R.id.loginSubmitButton)
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

