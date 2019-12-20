package com.project.hw.user

data class User(
    val avatarImageUrl: String,
    val login: String,
    val name: String,
    val bio: String,
    val followerCount: Int
)