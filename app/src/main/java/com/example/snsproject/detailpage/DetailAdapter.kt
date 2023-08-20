package com.example.snsproject.detailpage

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snsproject.R

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    var listData: List<DetailInfo> = emptyList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val creatorName: TextView = itemView.findViewById(R.id.item_createrName)
        val postTitle: TextView = itemView.findViewById(R.id.item_postTitle)
        val contents: TextView = itemView.findViewById(R.id.item_contents)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        holder.creatorName.text = item.name
        holder.postTitle.text = item.contentsTitle
        holder.contents.text = item.contents

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, getDetailPageActivityClass(position))
            Log.e("디테일", "클릭 ${position}")
            //intent.putExtra("user_name", item.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    private fun getDetailPageActivityClass(position: Int): Class<*> {
        Log.e("디테일", "${position}")
        return when (position) {
            0 -> DetailPage3Activity::class.java
            1 -> DetailPage1Activity::class.java
            2 -> DetailPage2Activity::class.java
            //3 -> DetailPageActivity::class.java
            else -> DetailPageActivity::class.java
        }
    }
}