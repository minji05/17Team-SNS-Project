package com.example.snsproject.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.snsproject.R
import com.example.snsproject.signinanduppage.UserInfo
import com.example.snsproject.signinanduppage.UserManager

class MyPageActivity : AppCompatActivity() {

    private lateinit var userInfo: UserInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        setSupportActionBar(requireViewById(R.id.toolbar_myPage))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val userId = intent.getStringExtra("id")
        if (userId != null) {
            userInfo = UserManager.findUser(userId) ?: UserInfo("", "", "", "")
            displayUserInfo()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_toolbar_mypage, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun displayUserInfo() {
        val txtName: TextView = findViewById(R.id.txt_name)
        val txtId: TextView = findViewById(R.id.txt_id)
        val txtMbti: TextView = findViewById(R.id.txt_mbti)

        txtName.text = userInfo.name
        txtId.text = userInfo.id
        txtMbti.text = userInfo.mbti
    }

}