package makingiants.com.uirobots

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class LoginActivity : AppCompatActivity() {

  val userRepository = UserRepository(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    findViewById<Button>(R.id.loginSubmitButton).setOnClickListener {
      submitLogin("username", "password")
    }
  }

  private fun submitLogin(userName: String, password: String) {
    userRepository.login(userName, password) {
      val intent = Intent(this@LoginActivity, MainActivity::class.java)
      startActivity(intent)
    }
  }
}
