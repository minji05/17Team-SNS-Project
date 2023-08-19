package com.example.snsproject.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.example.snsproject.R
import com.example.snsproject.signinanduppage.UserInfo

class MyPageActivity : AppCompatActivity() {

    private lateinit var userInfo: UserInfo
    //private lateinit var civProfile: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        setSupportActionBar(requireViewById(R.id.toolbar_myPage))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        userInfo = intent.getParcelableExtra("user_info") ?: UserInfo("", "", "", "")
        displayUserInfo()
        //displayProfileImage()

        //civProfile = findViewById(R.id.civ_profile)

        /*Glide.with(this)
            .load(userInfo.profile)
            .placeholder(R.drawable.iv_home_logo) // Placeholder image while loading
            .error(R.drawable.img_profile_add) // Image to display if loading fails
            .into(civProfile)*/
    }
    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_toolbar_mypage, menu)
        return true
    }*/

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
        val txtName = findViewById<TextView>(R.id.txt_name)
        val txtId = findViewById<TextView>(R.id.txt_id)
        val txtMbti = findViewById<TextView>(R.id.txt_mbti)

        txtName.text = userInfo.name
        txtId.text = userInfo.id
        txtMbti.text = userInfo.mbti
    }

    /*private fun displayProfileImage() {
        val profile: ImageView = findViewById(R.id.civ_profile)

        // Check if the profile image URI is not null and not empty
        if (!userInfo.profile.isNullOrEmpty()) {
            val profileUri = Uri.parse(userInfo.profile.toString())
            profile.setImageURI(profileUri)
        }
    }*/
}
