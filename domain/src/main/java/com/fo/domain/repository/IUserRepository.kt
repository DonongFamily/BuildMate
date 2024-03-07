package com.fo.domain.repository

import com.fo.domain.model.UserDto
import com.fo.domain.model.UserRequest
import kotlinx.coroutines.flow.Flow


interface IUserRepository {

    fun getUserFromDB(): Flow<UserDto>

    fun addUserToDB(user: UserRequest): Flow<Unit>

    fun deleteUserFromDB(user: UserRequest): Flow<Unit>
}