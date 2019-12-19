package com.project.hw.second_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.hw.R

class SecondViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val txtRvItem1: TextView =view.findViewById(R.id.grid_text1)
    val txtRvItem2: TextView =view.findViewById(R.id.grid_text2)

    fun bind(data: SecondItem){
        txtRvItem1.text=data.text1
        txtRvItem2.text=data.text2

    }
}