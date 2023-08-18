package com.example.snsproject.detailpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.example.snsproject.R

class DetailPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        //전달받은 데이터를 출력
        val text = intent.getStringExtra("dataFromFirstActivity")
        val TextView = findViewById<TextView>(R.id.intentContent)
        TextView.text ="${text}"

        val resId = intent.getIntExtra("imageResId", 1)
        val image = findViewById<ImageView>(R.id.intentImg)
        image.setImageResource(resId)


        setSupportActionBar(requireViewById(R.id.detailToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

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