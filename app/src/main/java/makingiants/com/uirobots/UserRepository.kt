package makingiants.com.uirobots

import android.content.Context
import android.preference.PreferenceManager

class UserRepository(val context: Context) {

  companion object {

    fun clear(context: Context) {
      PreferenceManager.getDefaultSharedPreferences(context).edit().clear().commit()
    }

  }

  val sharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

  var loginToken: String?
    get() = sharedPreferences.getString("token", null)
    set(value) {
      sharedPreferences.edit().putString("token", value).commit()
    }

  fun login(username: String, password: String, complete: (String) -> Unit) {
    loginToken = "token"
    complete("token")
  }

}