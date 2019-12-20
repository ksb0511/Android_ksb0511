package com.project.hw.main_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.hw.R
import com.project.hw.git_repo.GetGitRepoData
import com.project.hw.user.User


class MainAdapter (private val context: Context) : RecyclerView.Adapter<MainViewHolder>() {

    //var data : List<User> = listOf()
    var data : List<MainItem> = listOf()
    //var data: List<GetGitRepoData> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_main_item, parent, false)

        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
    }

}
