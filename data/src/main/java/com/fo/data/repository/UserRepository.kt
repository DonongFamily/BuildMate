package com.fo.data.repository

import com.fo.data.entity.toEntity
import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.model.UserDto
import com.fo.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(private val retrofitService: RetrofitService,
    private val dbService: DBService
): IUserRepository {
    override fun getUserFromDB(): Flow<List<UserDto>> =
        dbService.getUser().map { list ->
            list.map { value ->
                value.toDto()
            }
        }

    override fun addUserToDB(user: UserDto): Flow<Boolean> =
        dbService.addUser(user.toEntity())

    override fun deleteUserFromDB(user: UserDto): Flow<Boolean> =
        dbService.deleteUser(user.toEntity())
}