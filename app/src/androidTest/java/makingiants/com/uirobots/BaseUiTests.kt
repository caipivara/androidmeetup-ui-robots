package makingiants.com.uirobots

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import makingiants.com.uirobots.robots.LoginRobot
import makingiants.com.uirobots.robots.MainRobot
import org.junit.Before
import org.junit.Rule

open class BaseUiTests {

  @get:Rule
  private val rule = ActivityTestRule(MainActivity::class.java, false, false)

  @Before
  fun setUp() {
    UserRepository.clear(InstrumentationRegistry.getTargetContext())
    rule.launchActivity(null)
  }

  fun login(func: LoginRobot.() -> Unit) {
    LoginRobot(rule.activity).apply(func)
    return Unit
  }

  fun loginSuccessfully(func: MainRobot.() -> Unit) {
    LoginRobot(rule.activity).doLoginSuccessfully().apply(func)
    return Unit
  }


}