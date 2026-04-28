package com.example.myspendings

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

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // IDs from activity_register.xml
        val etUsername        = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword        = findViewById<TextInputEditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<TextInputEditText>(R.id.etConfirmPassword)
        val btnRegister       = findViewById<MaterialButton>(R.id.btnRegister)
        val tvLogin           = findViewById<TextView>(R.id.tvLogin)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirm  = etConfirmPassword.text.toString().trim()

            // Validation
            if (username.isEmpty()) {
                etUsername.error = getString(R.string.error_username_empty); return@setOnClickListener
            }
            if (password.isEmpty()) {
                etPassword.error = getString(R.string.error_password_empty); return@setOnClickListener
            }
            if (password.length < 6) {
                etPassword.error = "Password must be at least 6 characters"; return@setOnClickListener
            }
            if (password != confirm) {
                etConfirmPassword.error = getString(R.string.error_passwords_no_match); return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {
                val db = AppDatabase.getDatabase(applicationContext)
                val existing = db.userDao().findByUsername(username)
                withContext(Dispatchers.Main) {
                    if (existing != null) {
                        etUsername.error = getString(R.string.error_username_taken)
                    } else {
                        CoroutineScope(Dispatchers.IO).launch {
                            db.userDao().insert(User(username = username, password = password))
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Account created! Please log in.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                            }
                        }
                    }
                }
            }
        }

        tvLogin.setOnClickListener { finish() }
    }
}
