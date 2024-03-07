package com.fo.data.repository

import com.fo.data.entity.toEntity
import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.model.UserDto
import com.fo.domain.model.UserRequest
import com.fo.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(private val retrofitService: RetrofitService,
    private val dbService: DBService
): IUserRepository {
    override fun getUserFromDB(): Flow<UserDto> =
        dbService.getUser().map {
            it.toDto()
        }

    override fun addUserToDB(user: UserRequest): Flow<Unit> =
        dbService.addUser(user.toEntity())

    override fun deleteUserFromDB(user: UserRequest): Flow<Unit> =
        dbService.deleteUser(user.toEntity())
}