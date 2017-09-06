package makingiants.com.uirobots

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

  val userRepository = UserRepository(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (userRepository.loginToken == null) {
      startActivity(Intent(this, LoginActivity::class.java))
      finish()
    } else {
      setContentView(R.layout.activity_main)

      findViewById<Button>(R.id.mainLogoutButton).setOnClickListener {
        UserRepository.clear(this)

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        this.finish()
      }
    }
  }

}
