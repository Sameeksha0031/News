package com.example.exroomdatabase.model

import androidx.lifecycle.LiveData

class UserRepository(val userDao: UserDao) {

    val readAllData : LiveData<List<User>> = userDao.showData()

    suspend fun addUser(user : User) {
        userDao.insertData(user)
    }
}