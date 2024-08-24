package com.example.test.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test.data.model.Movie

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: Movie)

    @Query("SELECT * FROM movie")
    suspend fun getUsers(): List<Movie>

    @Delete
    suspend fun deleteUser(user: Movie)
}