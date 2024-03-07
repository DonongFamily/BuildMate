package com.fo.domain.usecase

import com.fo.domain.model.MaterialDto
import com.fo.domain.model.MaterialRequest
import com.fo.domain.repository.IMaterialRepository
import kotlinx.coroutines.flow.Flow

class GetMaterialListUseCase(
    private val materialRepository: IMaterialRepository
): IUseCase<MaterialRequest, List<MaterialDto>> {

    override suspend fun invoke(request: MaterialRequest): Flow<List<MaterialDto>> {
        return materialRepository.getMaterial(request)
    }
}