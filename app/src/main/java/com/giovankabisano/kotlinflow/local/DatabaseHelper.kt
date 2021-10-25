package com.giovankabisano.kotlinflow.local

import com.giovankabisano.kotlinflow.local.entity.User
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    fun getUsers(): Flow<List<User>>

    fun insertAll(users: List<User>):Flow<Unit>

}