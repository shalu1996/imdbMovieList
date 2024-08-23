package com.example.test.domain.di

import com.example.test.data.repoimpl.MoviesRepImpl
import com.example.test.database.AppDataBase
import com.example.test.domain.dao.UserDao
import com.example.test.domain.repository.MoviesRepository
import com.example.test.domain.usecase.MoviesUcImpl
import com.example.test.domain.usecase.MoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {
    @Singleton
    @Provides
    fun getDataBase(dataBase: AppDataBase): UserDao {
        return dataBase.getDao()
    }

    @Singleton
    @Provides
    fun getRepository(): MoviesRepository {
        return MoviesRepImpl()
    }

    @Singleton
    @Provides
    fun getUseCase(repository: MoviesRepository): MoviesUseCase {
        return MoviesUcImpl(repository)
    }

}