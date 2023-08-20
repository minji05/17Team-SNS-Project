package com.example.snsproject.detailpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.snsproject.MainActivity
import com.example.snsproject.R
import com.example.snsproject.signinanduppage.UserInfo

class DetailPostActivity : AppCompatActivity() {

    private lateinit var userInfo: UserInfo
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)

        setSupportActionBar(requireViewById(R.id.toolbar_detailPage))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        userInfo = intent.getParcelableExtra("user_info") ?: UserInfo("", "", "", "")
        if (userInfo != null) {
            val txtUserName = findViewById<TextView>(R.id.txt_createrNameSpace)
            txtUserName.text = userInfo.name

            val btnRegister = findViewById<Button>(R.id.btn_postcreate)
            btnRegister.setOnClickListener {
                val etTitle = findViewById<EditText>(R.id.et_postTitle)
                val etContents = findViewById<EditText>(R.id.et_postContent)

                val contentsTitle = etTitle.text.toString()
                val contents = etContents.text.toString()

                if (contentsTitle.isNotEmpty() && contents.isNotEmpty()) {
                    val detail = DetailInfo(userInfo.name, contentsTitle, contents)
                    DetailManager.addDetail(detail)
                }
                /*val contentsTitle = "Sample Title"
                val contents = "Sample Contents"
                val detail = DetailInfo(userInfo.name, contentsTitle, contents)
                DetailManager.addDetail(detail)*/

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        } else {
            Log.d("글작성", "글작성 실패")
        }
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
}