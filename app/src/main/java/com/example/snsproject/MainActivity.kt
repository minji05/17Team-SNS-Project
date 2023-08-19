package com.example.snsproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.snsproject.detailpage.DetailPageActivity
import com.example.snsproject.mypage.MyPageActivity
import com.example.snsproject.signinanduppage.SignInActivity
import com.example.snsproject.signinanduppage.UserManager

class MainActivity : AppCompatActivity() {

    private lateinit var et_container: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(requireViewById(R.id.toolbar_mainPage)) // 불러오기 // 툴바 뒤로가기
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바 TextView 타이틀 지움

        et_container = findViewById(R.id.et_container)
        val make_tv_button = findViewById<Button>(R.id.make_tv_button)

        val btnMyPage = findViewById<Button>(R.id.btn_myPage)

        btnMyPage.setOnClickListener {
            val userId = intent.getStringExtra("id")
            if (userId != null) {
                val user = UserManager.findUser(userId)
                if (user != null) {
                    //Log.d("ProfileImageDebug", "Profile Image URI: ${user.profile}")
                    val intent = Intent(this, MyPageActivity::class.java)
                    intent.putExtra("user_info", user)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "로그인 실패!!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        make_tv_button.setOnClickListener {
            val new_textView = TextView(this)
            new_textView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            new_textView.hint = "new"
            new_textView.setTextSize(45F)

            Log.d("SIZE", "사이즈 출력")
            new_textView.setTextColor(Color.GREEN)

            Log.d("SIZE", "컬러 출력")

            et_container.addView(new_textView)

            new_textView.setOnClickListener {
                val intent = Intent(this, DetailPageActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_SignIn -> {
                itemSignIn()
                return super.onOptionsItemSelected(item)
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun itemSignIn() {
        val userId = intent.getStringExtra("id")
        if (userId != null) {
            val user = UserManager.findUser(userId)
            if (user != null) {
                Toast.makeText(this, "이미 로그인 중", Toast.LENGTH_SHORT).show()
                Log.d("ProfileImageDebug", "Profile Image URI: ${user.profile}")
                /*val toolbar = findViewById<Toolbar>(R.id.toolbar_mainPage)
                val signInMenuItem = toolbar.menu.findItem(R.id.item_SignIn)

                if (!user.profile.isNullOrEmpty()) {
                    val profileUri = Uri.parse(user.profile)
                    try {
                        val inputStream = contentResolver.openInputStream(profileUri)
                        val profileIconBitmap = BitmapFactory.decodeStream(inputStream)
                        signInMenuItem.icon = BitmapDrawable(resources, profileIconBitmap)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }*/
            }
        } else {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}