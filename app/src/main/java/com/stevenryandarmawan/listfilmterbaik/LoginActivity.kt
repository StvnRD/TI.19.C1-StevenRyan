package com.stevenryandarmawan.listfilmterbaik

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private lateinit var binding: ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val datalogin = ModelLogin(binding.txtUsername.text.toString(),binding.txtPassword.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data",datalogin)
            startActivity(intent)
            finish()

        }
    }
}