package com.example.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.domain.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): UserDao
}