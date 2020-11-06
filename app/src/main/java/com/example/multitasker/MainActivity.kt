package com.example.multitasker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.logInBtn)

        loginBtn.setOnClickListener{
            val usernameTxt = username.text.toString()
            val passwordTxt = password.text.toString()

            if (usernameTxt == "username" && passwordTxt == "password"){
                displayHome()
            }
            else if (usernameTxt == "" || passwordTxt == ""){
                Toast.makeText(this, "Please fill out all of the fields", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun displayHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}