package makingiants.com.uirobots

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@Suppress("FunctionName")
@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTests : BaseUiTests() {

  @Test
  fun test_login_showMainView() = login {
    val mainRobot = writeEmail("james@bond.com")
        .writePassword("007")
        .clickLoginButton() // Returns MainRobot

    mainRobot.checkIsVisible()
  }

  @Test
  fun test_login_withEmptyEmail_showsError() = login {
    writeEmail("")
    writePassword("123")

    clickLoginButton()

    checkEmailHaveError()
  }

  @Test
  fun test_login_withEmptyPassword_showsError() = login {
    writeEmail("james@bond.com")
    writePassword("")
    clickLoginButton()

    checkPasswordHaveError()
  }

}

