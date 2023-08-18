package com.example.snsproject.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val btnReverse: Button = findViewById(R.id.btn_modify)
        val btnUpdate: Button = findViewById(R.id.btn_update)

        btnReverse.setOnClickListener {
            reverseText()
        }

        btnUpdate.setOnClickListener {
            textUpdate()
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
    private fun textUpdate(){
        val txtEmail: TextView = findViewById(R.id.textview_updateemail)
        val editPassword: EditText = findViewById(R.id.edittext_updatepassword)
        val editName: EditText = findViewById(R.id.edittext_updatename)
        val editBirthday: EditText = findViewById(R.id.edittext_updatebirthday)
        val editAddress: EditText = findViewById(R.id.edittext_updateaddress)

        txtEmail.text.toString()
        editPassword.text.toString()
        editName.text.toString()
        editBirthday.text.toString()
        editAddress.text.toString()
    }
    private fun firstReverseText() {
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