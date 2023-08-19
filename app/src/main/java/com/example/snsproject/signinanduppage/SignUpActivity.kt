package com.example.snsproject.signinanduppage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.snsproject.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var selectImgUri: Uri
    private val IMAGE_PICKER_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val etName = findViewById<EditText>(R.id.et_name)
        val etId = findViewById<EditText>(R.id.et_id)
        val etPw = findViewById<EditText>(R.id.et_pw)
        val etMbti = findViewById<EditText>(R.id.et_mbti)

        val btnSignUp = findViewById<Button>(R.id.btn_signUp)
        val btnCancel = findViewById<Button>(R.id.btn_cancel)

        val civProfile = findViewById<ImageView>(R.id.civ_profile)
        civProfile.setOnClickListener {
            openAlbum()
        }


        btnSignUp.setOnClickListener {
            if (etName.text.toString().isNotBlank() && etId.text.toString().isNotBlank() && etPw.text.toString().isNotBlank() && etMbti.text.toString().isNotBlank()
            ) {
                val userInfo = UserInfo(
                    etName.text.toString(),
                    etId.text.toString(),
                    etPw.text.toString(),
                    etMbti.text.toString(),
                )

                userInfo.profile = selectImgUri.toString()

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

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun openAlbum() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, IMAGE_PICKER_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            selectImgUri = data.data ?: return
            val civProfile = findViewById<ImageView>(R.id.civ_profile)
            civProfile.setImageURI(selectImgUri)
        }
    }
}
