package com.example.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.data.model.Movie
import com.example.test.domain.dao.MovieDao

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): MovieDao
}