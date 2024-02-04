package com.example.exroomdatabase.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Convertors {
    @TypeConverter
    fun fromArrayList(value : ArrayList<Address>) : String {

        
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toArrayList(value : String) : ArrayList<Address> {
        val listType = object  : TypeToken<ArrayList<Address>>(){}.type
        return Gson().fromJson(value,listType)
    }
}