package makingiants.com.uirobots.robots

import android.app.Activity
import android.support.test.espresso.matcher.ViewMatchers
import android.view.View
import makingiants.com.uirobots.R
import org.hamcrest.Matchers

class LoginRobot(activity: Activity) : BaseRobot(activity) {

  fun performLoginFlow(): MainRobot {
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

  fun isVisible() {
    Matchers.allOf<View>(ViewMatchers.withText("Login"), ViewMatchers.isDisplayed())
  }
}

