package com.jorge.practice3.login.data.repositories

import com.jorge.practice3.login.domain.repositories.LoginRepository

class LoginRepositoryImpl : LoginRepository {

    private val usernames: MutableList<String> = mutableListOf()
    private val passwords: MutableList<String> = mutableListOf()

    override suspend fun login(username: String, password: String) {
        usernames.add(username)
        passwords.add(password)
    }

}