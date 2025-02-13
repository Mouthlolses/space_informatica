package com.example.space_informatica.ui.client.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "users")
@Parcelize
data class User(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "user_name") val nome: String,
    val email: String,
    val password: String
) : Parcelable
