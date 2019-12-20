package com.project.hw.main_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.hw.R
import com.project.hw.git_repo.GitRepoRepository
import com.project.hw.user.GetUserData
import com.project.hw.user.UserRepository
import kotlinx.android.synthetic.main.activity_main_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainListActivity : AppCompatActivity() {
    private lateinit var adapter : MainAdapter
    private lateinit var mainGitRepo : RecyclerView
    private val repository = DummyRepoRepository()

    //로그인 프로필에 관한 것

    /*private val userRepository : UserRepository=ServerUserRepository()
    private val gitRepoRepository : GitRepoRepository= ServerGitRepoRepository()*/
    private var login:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        //makeProfile()
        initGitRepoList()
    }

    /*
    private fun makeProfile() {

        // 현재 사용자 정보를 비동기적으로 받아온다.
        // Callback 내부의 코드는 나중에 데이터를 받아오고 실행된다.
        userRepository.getUser(login).enqueue(object : Callback<GetUserData> {
            override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("sopt_git_star", "error : $t")
            }

            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                if (response.isSuccessful) {
                    val currentUser = response.body()!! // TODO 여기서 body 가 없다면, 어플리케이션이 죽을 것이다 어떻게 해야할까?

                    // 더미 데이터를 이용해 Profile을 채운다.
                    profile_login.text = currentUser.login
                    profile_name.text = currentUser.name
                    profile_description.text = currentUser.bio
                }
            }
        })
    }*/

    private fun initGitRepoList(){
        mainGitRepo=findViewById(R.id.rvMainGitRepo)

        adapter=MainAdapter(this)

        mainGitRepo.adapter=adapter

        val llm=LinearLayoutManager(this)
        llm.orientation=LinearLayoutManager.VERTICAL

        mainGitRepo.setLayoutManager(llm)
        mainGitRepo.setAdapter(adapter)

        // 지정한 사용자의 팔로워 정보를 비동기적으로 받아온다.
        // Callback 내부의 코드는 나중에 데이터를 받아오고 실행된다.
/*        gitRepoRepository.getRepos(login).enqueue(object : Callback<List<GetGitRepoData>> {
            override fun onFailure(call: Call<List<GetGitRepoData>>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("sopt_git_star", "error : $t")
            }

            override fun onResponse(call: Call<List<GetGitRepoData>>, response: Response<List<GetGitRepoData>>) {
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                if (response.isSuccessful) {
                    val gitRepos = response.body()!! // TODO 여기서 body 가 없다면, 어플리케이션이 죽을 것이다 어떻게 해야할까?

                    // adapter에 데이터 갱신하기
                    // 데이터의 소스는 repository가 관리한다.
                    adapter.data = gitRepos
                    // 데이터 갱신한 다음, 어뎁터에게 다시 그리라고 알려준다. (이거 안하면 변화가 갱신되지 않는다.)
                    adapter.notifyDataSetChanged()
                }
            }
        })
 */
        adapter.data=repository.getRepoList()

        adapter.notifyDataSetChanged()
    }
}
