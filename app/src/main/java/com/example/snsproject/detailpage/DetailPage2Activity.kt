package com.example.snsproject.detailpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.snsproject.R

class DetailPage2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)


        //전달받은 데이터를 출력
        val intent = intent.getStringExtra("dataFromFirstActivity")
        val idText = findViewById<TextView>(R.id.detailID)
        idText.text ="아이디 : ${intent}"


//        //뒤로가기 버튼 누를 시
//        val btn = findViewById<Button>(R.id.backBtn)
//        btn.setOnClickListener {
//            finish()
//        }
//

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