package com.example.snsproject

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.snsproject.detailpage.DetailAdapter
import com.example.snsproject.detailpage.DetailInfo
import com.example.snsproject.detailpage.DetailManager
import com.example.snsproject.detailpage.DetailPageActivity
import com.example.snsproject.detailpage.DetailPostActivity
import com.example.snsproject.detailpage.SampleDataManager
import com.example.snsproject.mypage.MyPageActivity
import com.example.snsproject.mypage.MyPageHHActivity
import com.example.snsproject.mypage.MyPageMJActivity
import com.example.snsproject.mypage.MyPageSJActivity
import com.example.snsproject.signinanduppage.SignInActivity
import com.example.snsproject.signinanduppage.UserInfo
import com.example.snsproject.signinanduppage.UserManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var et_container: LinearLayout

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DetailAdapter
    private lateinit var posts: List<DetailInfo>

    init{
        instance = this
    }

    companion object{
        private var instance:MainActivity? = null
        fun getInstance(): MainActivity? {
            return instance
        }
    }
    private var isSampleDataInitialized = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(requireViewById(R.id.toolbar_mainPage))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnMyPagedh = findViewById<ShapeableImageView>(R.id.btn_myPagedh)
        btnMyPagedh.setOnClickListener {
            itemMyPage()
        }

        val btnMyPagesj = findViewById<ShapeableImageView>(R.id.btn_myPagesj)
        btnMyPagesj.setOnClickListener {
            val intent = Intent(this, MyPageSJActivity::class.java)
            startActivity(intent)
        }
        val btnMyPagemj = findViewById<ShapeableImageView>(R.id.btn_myPagemj)
        btnMyPagemj.setOnClickListener {
            val intent = Intent(this, MyPageMJActivity::class.java)
            startActivity(intent)
        }
        val btnMyPagehh = findViewById<ShapeableImageView>(R.id.btn_myPagehh)
        btnMyPagehh.setOnClickListener {
            val intent = Intent(this, MyPageHHActivity::class.java)
            startActivity(intent)
        }

        /*et_container = findViewById(R.id.et_container)
        val make_tv_button = findViewById<Button>(R.id.make_tv_button)

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
        }*/
        /*initialize()
        recyclerView = findViewById(R.id.recycler_post)
        adapter = DetailAdapter(this, posts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter*/

        SampleDataManager.initializeSampleData()
        initializeRecyclerView()

        val fab = findViewById<FloatingActionButton>(R.id.flo_postCreate)
        fab.setOnClickListener {
            val userId = intent.getStringExtra("id")
            if (userId != null) {
                val user = UserManager.findUser(userId)
                if (user != null) {
                    val intent = Intent(this, DetailPostActivity::class.java)
                    intent.putExtra("user_info", user)
                    Log.d("로그인", "${user.name}")
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "로그인을 먼저 해주세요", Toast.LENGTH_SHORT).show()
                }
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
                Log.d("함수", "이전${user.profile}")
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
    private fun itemMyPage(){
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
    private fun initializeRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_post)
        val adapter = DetailAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val details = DetailManager.getAllDetails()
        adapter.listData = details
        adapter.notifyDataSetChanged()
    }

    /*private fun updateProfileIcon(user: UserInfo) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar_mainPage)
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
        }
    }*/
}