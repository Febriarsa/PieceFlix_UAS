package com.example.uas_ppapb.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room.databaseBuilder
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// Anotasi @Database untuk mendefinisikan database dengan tabel-tabel terkait dan versi database
@Database(entities = [Local::class, FilmFavorite::class], version = 2, exportSchema = true)
abstract class LocalRoomDatabase : RoomDatabase() {

    abstract fun localDao() : LocalDao?

    abstract fun filmFavoriteDao() : FilmFavoriteDao?

    companion object {
        @Volatile
        private var INSTANCE: LocalRoomDatabase? = null

        fun getDatabase(context: Context): LocalRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(LocalRoomDatabase::class.java) {
                    INSTANCE = databaseBuilder(
                        context.applicationContext,
                        LocalRoomDatabase::class.java,
                        "movie_database"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("""
            CREATE TABLE IF NOT EXISTS film_favorite_table (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                filmId TEXT NOT NULL 
            )
        """)
            }
        }
    }
}
