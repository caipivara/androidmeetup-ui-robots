package makingiants.com.uirobots.utils

import android.view.View
import android.widget.EditText
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


object CustomMatchers {

  /**
   * src https://stackoverflow.com/a/38874162/273119
   */
  fun withError(): Matcher<View> {
    return object : TypeSafeMatcher<View>() {

      public override fun matchesSafely(view: View) = (view as? EditText)?.error != null

      override fun describeTo(description: Description) {}

    }
  }

}
