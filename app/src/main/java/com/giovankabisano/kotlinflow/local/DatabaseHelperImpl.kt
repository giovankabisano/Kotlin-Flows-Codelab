package com.giovankabisano.kotlinflow.local

import com.giovankabisano.kotlinflow.local.AppDatabase
import com.giovankabisano.kotlinflow.local.DatabaseHelper
import com.giovankabisano.kotlinflow.local.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override fun getUsers(): Flow<List<User>> =
        flow { emit(appDatabase.userDao().getAll()) }

    override fun insertAll(users: List<User>): Flow<Unit> = flow {
        appDatabase.userDao().insertAll(users)
        emit(Unit)
    }

}