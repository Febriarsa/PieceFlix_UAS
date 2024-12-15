package com.example.uas_ppapb.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Deklarasi entitas tabel untuk Room Database dengan nama tabel "film_favorite_table"
@Entity(tableName = "film_favorite_table")
data class FilmFavorite (

    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int = 0,

    @ColumnInfo(name = "filmId")
    val filmId: String
)
