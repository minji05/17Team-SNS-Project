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

        val etName = findViewById<EditText>(R.id.et_name)
        val etId = findViewById<EditText>(R.id.et_id)
        val etPw = findViewById<EditText>(R.id.et_pw)
        val etMbti = findViewById<EditText>(R.id.et_mbti)

        val btn_signUp = findViewById<Button>(R.id.btn_signUp)
        val btn_cancel = findViewById<Button>(R.id.btn_cancel)

        btn_signUp.setOnClickListener {
            if (etName.text.toString().isNotBlank() && etId.text.toString().isNotBlank() && etPw.text.toString().isNotBlank() && etMbti.text.toString().isNotBlank())
            {
                val userInfo = UserInfo(
                    etName.text.toString(),
                    etId.text.toString(),
                    etPw.text.toString(),
                    etMbti.text.toString()
                )

                UserManager.addUser(userInfo)

                Toast.makeText(this, "회원가입 성공!!", Toast.LENGTH_SHORT).show()

                val intent = Intent().apply {
                    putExtra("id", etId.text.toString())
                    putExtra("pw", etPw.text.toString())
                }

                setResult(RESULT_OK, intent)
                if (!isFinishing) finish()
            } else {
                Toast.makeText(this, "빈칸을 채워 주세요", Toast.LENGTH_SHORT).show()
            }
        }

        btn_cancel.setOnClickListener {
            finish()
        }
    }
}
