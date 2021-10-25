package com.giovankabisano.kotlinflow.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.giovankabisano.kotlinflow.local.dao.UserDao
import com.giovankabisano.kotlinflow.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}