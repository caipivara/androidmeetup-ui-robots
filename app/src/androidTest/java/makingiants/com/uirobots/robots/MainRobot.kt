package makingiants.com.uirobots.robots

import android.app.Activity
import makingiants.com.uirobots.R

class MainRobot(activity: Activity) : BaseRobot(activity) {

  fun clickLogoutButton(): LoginRobot {
    click(R.id.mainLogoutButton)
    return LoginRobot(activity)
  }

  fun checkIsVisible() {
    checkViewWithTextIsVisible("Main")
  }

}