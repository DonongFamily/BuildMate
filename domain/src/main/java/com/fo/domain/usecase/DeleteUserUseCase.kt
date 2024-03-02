package com.fo.domain.usecase

import com.fo.domain.model.UserDto
import com.fo.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class DeleteUserUseCase(
    private val userRepository: IUserRepository
) : IUseCase<UserDto, Boolean> {

    override suspend fun invoke(request: UserDto): Flow<Boolean> =
        userRepository.deleteUserFromDB(request)
}