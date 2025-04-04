package com.example.space_informatica.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Usuarios(
    
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val email: String,
    val password: String

) : Parcelable