package com.example.exroomdatabase.model

import android.content.Context
import androidx.room.*

@Database(entities = [User::class], version = 5, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE : AppDataBase ?= null

        fun getDataBase(context : Context) : AppDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}