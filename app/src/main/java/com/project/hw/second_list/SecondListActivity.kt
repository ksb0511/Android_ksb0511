package com.project.hw.second_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.hw.R

class SecondListActivity : AppCompatActivity() {
    private lateinit var adapter : SecondAdapter
    private lateinit var mainGitRepo : RecyclerView
    private val repository = SecondRepoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_list)

        initGitRepoList()
    }

    private fun initGitRepoList(){
        mainGitRepo=findViewById(R.id.rvMainGitRepo2)

        adapter= SecondAdapter(this)

        mainGitRepo.adapter=adapter

        val grid=GridLayoutManager(this, 3)

        mainGitRepo.setLayoutManager(grid)
        mainGitRepo.setAdapter(adapter)

        adapter.data=repository.getRepoList()

        adapter.notifyDataSetChanged()
    }
}
