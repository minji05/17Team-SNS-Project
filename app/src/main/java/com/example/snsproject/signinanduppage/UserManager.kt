package com.example.snsproject.signinanduppage

object UserManager {
    private val users: MutableMap<String, UserInfo> = mutableMapOf()

    fun addUser(userInfo: UserInfo) {
        users[userInfo.id] = userInfo
    }

    fun findUser(id: String): UserInfo? {
        return users[id]
    }

    fun removeUser(id: String) {
        users.remove(id)
    }
}