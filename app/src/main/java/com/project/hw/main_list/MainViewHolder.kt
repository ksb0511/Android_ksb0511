package com.project.hw.main_list

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.hw.R
import com.project.hw.git_repo.GetGitRepoData
import com.project.hw.second_list.SecondListActivity


class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val rv_image: ImageView =view.findViewById(R.id.item_image)
    val rv_title: TextView =view.findViewById(R.id.txt_title)
    val rv_desc: TextView =view.findViewById(R.id.txt_description)
    val rv_language: TextView=view.findViewById(R.id.txt_language)
    val rv_update: TextView=view.findViewById(R.id.txt_updated)


    fun bind(data: MainItem){
        /*
        rv_title.text=data.name
        rv_desc.text=data.description
        rv_language.text=data.language
        rv_update.text=data.updatedAt
*/
        rv_title.text=data.text1
        rv_desc.text=data.text2
        rv_language.text=data.text3
        rv_update.text=data.text4

        itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, SecondListActivity::class.java)

            // 선택한 팔로워 이름을 전달한다.
            //intent.putExtra("follower_name", follower.login)

            context.startActivity(intent)
        }
    }
}