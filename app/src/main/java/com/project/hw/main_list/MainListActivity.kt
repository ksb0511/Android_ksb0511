package com.project.hw.main_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.hw.R

class MainListActivity : AppCompatActivity() {
    private lateinit var adapter : MainAdapter
    private lateinit var mainGitRepo : RecyclerView
    private val repository = MainRepoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        initGitRepoList()
    }

    private fun initGitRepoList(){
        mainGitRepo=findViewById(R.id.rvMainGitRepo)

        adapter=MainAdapter(this)

        mainGitRepo.adapter=adapter

        val llm=LinearLayoutManager(this)
        llm.orientation=LinearLayoutManager.VERTICAL

        mainGitRepo.setLayoutManager(llm)
        mainGitRepo.setAdapter(adapter)

        adapter.data=repository.getRepoList()

        adapter.notifyDataSetChanged()
    }
}
