package com.fo.domain.usecase

import com.fo.domain.model.SampleDto
import com.fo.domain.model.SampleRequest
import com.fo.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class SampleUseCase(
    private val userRepository: IUserRepository
): IUseCase<SampleRequest, SampleDto> {

    override suspend fun invoke(request: SampleRequest): Flow<SampleDto> {
        return userRepository.getSample(request)
    }
}