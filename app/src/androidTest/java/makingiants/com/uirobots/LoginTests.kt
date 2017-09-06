package makingiants.com.uirobots

import android.support.test.InstrumentationRegistry
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import makingiants.com.uirobots.robots.LoginRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTests {

  @get:Rule
  var rule = ActivityTestRule(MainActivity::class.java, false, false)

  lateinit var loginRobot: LoginRobot

  @Before
  fun setUp() {
    UserRepository.clear(InstrumentationRegistry.getTargetContext())
    rule.launchActivity(null)
    loginRobot = LoginRobot(rule.activity)
  }

  @Test
  fun test_login_showMainView() {
    val mainRobot = loginRobot.writeEmail("test@gmail.com")
        .writePassword("123")
        .clickLoginButton() // Returns MainRobot

    mainRobot.isVisible()
  }

}
