package com.example.snsproject.signinanduppage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.snsproject.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val et_name = findViewById<EditText>(R.id.et_name)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)

        val btn_signUp = findViewById<Button>(R.id.button9)
        val btn_cancel = findViewById<Button>(R.id.button8)

        btn_signUp.setOnClickListener{
            if(et_name.text.toString().trim().isEmpty()||et_id.text.toString().trim().isEmpty()||et_pw.text.toString().trim().isEmpty()){
                Toast.makeText(this, getString(R.string.toast_msg_noinput), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val intent = Intent(this, SignInActivity::class.java).apply {
                putExtra("id", et_id.text.toString())
                putExtra("pw", et_pw.text.toString())
            }

            setResult(RESULT_OK, intent)

            if (!isFinishing) finish()

        }

        btn_cancel.setOnClickListener {
            finish()
        }
    }
}