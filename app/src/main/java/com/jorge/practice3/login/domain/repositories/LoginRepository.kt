package com.jorge.practice3.login.domain.repositories

interface LoginRepository {

    suspend fun login(username: String, password: String)

}