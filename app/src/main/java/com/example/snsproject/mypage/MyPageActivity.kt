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

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        firstReverseText()

        setSupportActionBar(requireViewById(R.id.toolbar_myPage))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnUpdate = findViewById<Button>(R.id.btn_update)

        /*
        val txt_email = findViewById<TextView>(R.id.email)
        val txt_pw = findViewById<TextView>(R.id.pw)
        val txt_name = findViewById<TextView>(R.id.name)
        val txt_birthday = findViewById<TextView>(R.id.birthday)
        val txt_address = findViewById<TextView>(R.id.address)

        val ed_pw = findViewById<EditText>(R.id.pw)
        val ed_name = findViewById<EditText>(R.id.name)
        val ed_birthday = findViewById<EditText>(R.id.birthday)
        val ed_address = findViewById<EditText>(R.id.address)

        //회원가입 값 자동 받기
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Result_OK) {
                val m_email = it.data?.getStringExtra("email") ?:""
                val m_pw = it.data?.getStringExtra("pw") ?:""
                val m_name = it.data?.getStringExtra("name") ?:""
                val m_birthday = it.data?.getStringExtra("birthday") ?:""
                val m_address = it.data?.getStringExtra("address") ?:""

                txt_email.setText(m_email)
                txt_pw.setText(m_email)
                txt_name.setText(m_email)
                txt_birthday.setText(m_email)
                txt_address.setText(m_email)
            }
        }
        // 회원가입 값 보내기
        val intent = Intent(this, MainActivity::class.java).apply{
            putExtra("email", txt_email.text.toString()) 등등  data에 따라 달라짐
        }
        setResult(RESULT_OK, intent)
        if(!isFinshing) finish()

        //로그인 값 보내기
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("email", txt_email.text.toString())
        startActivity(intent)

        //회원가입 값 자동 받기
        val intent = Intent(this, SignUpActivity::class.java)
        activityResultLauncher.launcher(intent)

        //메인에서 로그인 된 값 받기
        val txt_email = findViewById<TExtView>(R.id.email)
        if(intent.hasExtra("email")){
            txt_email.text = "아이디: " + intent.getStringExtra("email")
        }
         */

        btnUpdate.setOnClickListener {
            textUpdate()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_toolbar_mypage, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_modify-> {
                reverseText()
                return super.onOptionsItemSelected(item)
            }
            android.R.id.home -> {
                finish()
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun textUpdate(){
        val txtEmail = findViewById<TextView>(R.id.textview_updateemail)
        val editPassword = findViewById<EditText>(R.id.edittext_updatepassword)
        val editName = findViewById<EditText>(R.id.edittext_updatename)
        val editBirthday = findViewById<EditText>(R.id.edittext_updatebirthday)
        val editAddress = findViewById<EditText>(R.id.edittext_updateaddress)

        txtEmail.text.toString()
        editPassword.text.toString()
        editName.text.toString()
        editBirthday.text.toString()
        editAddress.text.toString()
    }
    private fun firstReverseText() {
        val txtEmail = findViewById<TextView>(R.id.textview_updateemail)
        val txtPassword = findViewById<TextView>(R.id.textview_updatepassword)
        val txtName = findViewById<TextView>(R.id.textview_updatename)
        val txtBirthday = findViewById<TextView>(R.id.textview_updatebirthday)
        val txtAddress = findViewById<TextView>(R.id.textview_updateaddress)

        val editPassword = findViewById<EditText>(R.id.edittext_updatepassword)
        val editName = findViewById<EditText>(R.id.edittext_updatename)
        val editBirthday = findViewById<EditText>(R.id.edittext_updatebirthday)
        val editAddress = findViewById<EditText>(R.id.edittext_updateaddress)

        if (txtPassword.visibility.equals(View.VISIBLE) &&
            txtName.visibility.equals(View.VISIBLE) &&
            txtBirthday.visibility.equals(View.VISIBLE) &&
            txtAddress.visibility.equals(View.VISIBLE)
        ) {
            txtEmail.setText("이메일 intent 받기")

            editPassword.setVisibility(View.VISIBLE)
            txtPassword.setVisibility(View.GONE)
            txtPassword.setText("패스워트 intent 받기")

            editName.setVisibility(View.VISIBLE)
            txtName.setVisibility(View.GONE)
            txtName.setText("이름 intent 받기")

            editBirthday.setVisibility(View.VISIBLE)
            txtBirthday.setVisibility(View.GONE)
            txtBirthday.setText("생일 intent 받기")

            editAddress.setVisibility(View.VISIBLE)
            txtAddress.setVisibility(View.GONE)
            txtAddress.setText("주소 intent 받기")

        }
    }
    private fun reverseText() {
        val txtEmail: TextView = findViewById(R.id.textview_updateemail)
        val txtPassword: TextView = findViewById(R.id.textview_updatepassword)
        val txtName: TextView = findViewById(R.id.textview_updatename)
        val txtBirthday: TextView = findViewById(R.id.textview_updatebirthday)
        val txtAddress: TextView = findViewById(R.id.textview_updateaddress)

        val editPassword: EditText = findViewById(R.id.edittext_updatepassword)
        val editName: EditText = findViewById(R.id.edittext_updatename)
        val editBirthday: EditText = findViewById(R.id.edittext_updatebirthday)
        val editAddress: EditText = findViewById(R.id.edittext_updateaddress)

        if (txtPassword.visibility.equals(View.VISIBLE) &&
            txtName.visibility.equals(View.VISIBLE) &&
            txtBirthday.visibility.equals(View.VISIBLE) &&
            txtAddress.visibility.equals(View.VISIBLE)
        ) {
            txtEmail.setText("이메일 intent 받기")

            editPassword.setVisibility(View.VISIBLE)
            txtPassword.setVisibility(View.GONE)
            editPassword.setText("패스워트 intent 받기")

            editName.setVisibility(View.VISIBLE)
            txtName.setVisibility(View.GONE)
            editName.setText("이름 intent 받기")

            editBirthday.setVisibility(View.VISIBLE)
            txtBirthday.setVisibility(View.GONE)
            editBirthday.setText(
                "생일 intent 받기"
            )

            editAddress.setVisibility(View.VISIBLE)
            txtAddress.setVisibility(View.GONE)
            editAddress.setText("주소 intent 받기")

        } else if (editPassword.visibility.equals(View.VISIBLE) &&
            editName.visibility.equals(View.VISIBLE) &&
            editBirthday.visibility.equals(View.VISIBLE) &&
            editAddress.visibility.equals(View.VISIBLE)
        ) {
            txtEmail.setText(
                "이메일 intent 받기"
            )

            editPassword.setVisibility(View.GONE)
            txtPassword.setVisibility(View.VISIBLE)
            txtPassword.setText(
                "패스워트 intent 받기"
            )

            editName.setVisibility(View.GONE)
            txtName.setVisibility(View.VISIBLE)
            txtName.setText(
                "이름 intent 받기"
            )

            editBirthday.setVisibility(View.GONE)
            txtBirthday.setVisibility(View.VISIBLE)
            txtBirthday.setText(
                "생일 intent 받기"
            )

            editAddress.setVisibility(View.GONE)
            txtAddress.setVisibility(View.VISIBLE)
            txtAddress.setText(
                "주소 intent 받기"
            )
        }
    }
}