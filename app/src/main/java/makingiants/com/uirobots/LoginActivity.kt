package makingiants.com.uirobots

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

  val userRepository = UserRepository(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    findViewById<Button>(R.id.loginSubmitButton).setOnClickListener {
      submitLogin(findViewById<EditText>(R.id.loginUsernameEditText).text.toString(),
          findViewById<EditText>(R.id.loginPasswordEditText).text.toString())
    }
  }

  private fun submitLogin(userName: String, password: String) {
    if (userName.isEmpty()) {
      findViewById<EditText>(R.id.loginUsernameEditText).error = "This field cant be empty"
      return
    }

    if (password.isEmpty()) {
      findViewById<EditText>(R.id.loginPasswordEditText).error = "This field cant be empty"
      return
    }

    userRepository.login(userName, password) {
      val intent = Intent(this@LoginActivity, MainActivity::class.java)
      startActivity(intent)
    }
  }

}