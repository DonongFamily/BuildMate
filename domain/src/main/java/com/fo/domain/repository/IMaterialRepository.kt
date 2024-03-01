package com.fo.domain.repository

import com.fo.domain.model.MaterialDto
import com.fo.domain.model.MaterialRequest
import kotlinx.coroutines.flow.Flow

interface IMaterialRepository {

    fun getMaterial(materialRequest: MaterialRequest): Flow<List<MaterialDto>>
}