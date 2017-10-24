package makingiants.com.uirobots

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@Suppress("FunctionName")
@LargeTest
@RunWith(AndroidJUnit4::class)
class MainTests : BaseUiTests() {

  @Test
  fun test_onLogout_showLoginView() = loginSuccessfully {
    val loginRobot = clickLogoutButton()
    loginRobot.checkIsVisible()
  }

}