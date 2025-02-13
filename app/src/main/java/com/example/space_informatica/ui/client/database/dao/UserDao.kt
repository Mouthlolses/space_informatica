package com.example.space_informatica.ui.client.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.space_informatica.ui.client.database.model.User


@Dao
interface UserDao {

    @Insert
    fun salva(vararg user: User)

}