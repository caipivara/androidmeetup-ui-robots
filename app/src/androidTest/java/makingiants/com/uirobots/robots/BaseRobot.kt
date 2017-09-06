package makingiants.com.uirobots.robots

import android.app.Activity
import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.runner.lifecycle.Stage
import android.view.View
import android.view.WindowManager.LayoutParams.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.startsWith

open class BaseRobot(val activity: Activity) {

  init {
    //
    // TODO: checkIntents https://discuss.circleci.com/t/wakeupdevice-runnable-is-not-working/9543
    ///**
    // * https://circleci.com/docs/android/
    // */
    ActivityLifecycleMonitorRegistry.getInstance()
        .addLifecycleCallback { activity, stage ->
          if (stage == Stage.PRE_ON_CREATE) {
            activity.window.addFlags(FLAG_DISMISS_KEYGUARD or FLAG_TURN_SCREEN_ON or
                FLAG_KEEP_SCREEN_ON or FLAG_SHOW_WHEN_LOCKED)
          }
        }
  }

  protected fun write(@IdRes id: Int, text: String) {
    onView(withId(id)).perform(typeText(text), closeSoftKeyboard())
  }

  protected fun click(@IdRes id: Int) {
    onView(withId(id)).perform(ViewActions.click())
  }

  protected fun clickViewWithText(text: String) {
    onView(allOf<View>(withText(text), isDisplayed())).perform(ViewActions.click())
  }

  protected fun clickViewStartingWithText(text: String) {
    onView(withText(startsWith(text))).perform(ViewActions.click())
  }

  protected fun clickChildViewWithContentDescription(@IdRes id: Int, text: String) {
    onView(allOf<View>(withContentDescription(text), withParent(withId(id))))
        .perform(ViewActions.click())
  }

  protected fun checkViewWithTextIsVisible(text: String) {
    onView(withText(text)).check(matches(isDisplayed()))
  }

}

