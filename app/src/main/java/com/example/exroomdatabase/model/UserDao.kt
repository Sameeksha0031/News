package com.example.exroomdatabase.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exroomdatabase.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertData(user : User)

    @Query("SELECT * FROM user_table")
    fun showData() : LiveData<List<User>>
}