package com.project.hw.second_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.hw.R

class SecondAdapter(private val context: Context) : RecyclerView.Adapter<SecondViewHolder>() {

    var data : List<SecondItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_second_item, parent, false)

        return SecondViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.bind(data[position])
    }

}
