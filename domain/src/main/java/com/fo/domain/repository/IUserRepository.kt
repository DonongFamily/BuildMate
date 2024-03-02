package com.fo.domain.repository

import com.fo.domain.model.UserDto
import com.fo.domain.model.UserRequest
import kotlinx.coroutines.flow.Flow


interface IUserRepository {

    fun getUserFromDB(): Flow<List<UserDto>>

    fun addUserToDB(user: UserDto): Flow<Boolean>

    fun deleteUserFromDB(user: UserDto): Flow<Boolean>
}