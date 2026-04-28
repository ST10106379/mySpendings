package com.example.myspendings

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // If already logged in skip straight to MainActivity
        if (SessionManager.isLoggedIn(this)) {
            goToMain()
            return
        }

        setContentView(R.layout.activity_login)

        // IDs from activity_login.xml
        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin   = findViewById<MaterialButton>(R.id.btnLogin)
        val tvSignUp   = findViewById<TextView>(R.id.tvSignUp)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty()) {
                etUsername.error = getString(R.string.error_username_empty)
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                etPassword.error = getString(R.string.error_password_empty)
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {
                val user = AppDatabase.getDatabase(applicationContext)
                    .userDao().login(username, password)
                withContext(Dispatchers.Main) {
                    if (user != null) {
                        SessionManager.saveUser(applicationContext, user.id, user.username)
                        goToMain()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.error_invalid_credentials),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        tvSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
