package com.example.space_informatica.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.space_informatica.model.Usuarios

@Database(entities = [Usuarios::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {


}