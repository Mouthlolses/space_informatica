package com.example.space_informatica.ui.client.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.space_informatica.ui.client.database.dao.UserDao
import com.example.space_informatica.ui.client.database.model.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao


    companion object {
        fun instacia(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "space_informatica.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}