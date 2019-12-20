package com.project.hw.user

import retrofit2.Call

interface UserRepository {
    /**
     * login 에 해당하는 유저 정보를 받아온다.
     * */
    //fun getUser(login: String): Call<GetUserData>
    fun getUser(login: String): User

    /**
     * login 에 해당하는 유저를 팔로우하는 유저 리스트를 받아온다.
     * */
    //fun getFollowers(login: String): Call<List<GetFollowerData>>
    fun getFollowers(login: String): List<User>
}