package com.example.exroomdatabase.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var fname : String,
    var lname : String,
    var age : Int,
    @Embedded
    var address: ArrayList<Address>
)
data class Address(
    var country : String,
    var city : String,
)

