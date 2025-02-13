package com.example.space_informatica.database.dao

import androidx.room.Insert
import com.example.space_informatica.database.model.User

interface UserDao {

    @Insert
    fun salva(vararg user: User)
}