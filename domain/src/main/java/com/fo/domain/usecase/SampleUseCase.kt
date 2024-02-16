package com.fo.domain.usecase

import com.fo.domain.model.SampleDto
import com.fo.domain.model.SampleRequest
import com.fo.domain.repository.ISampleRepository
import kotlinx.coroutines.flow.first
import java.lang.Exception

class SampleUseCase(
    private val sampleRepository: ISampleRepository
): IUseCase<SampleRequest, SampleDto> {

    override suspend fun invoke(request: SampleRequest): Result<SampleDto> {
        return try {
            val dto = sampleRepository.getSample(request).first()
            Result.success(dto)
        } catch (_: Exception) {
            Result.failure(Exception())
        }
    }
}