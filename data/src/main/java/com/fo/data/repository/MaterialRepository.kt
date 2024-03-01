package com.fo.data.repository

import com.fo.data.model.toRequest
import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.model.MaterialDto
import com.fo.domain.model.MaterialRequest
import com.fo.domain.repository.IMaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MaterialRepository(private val retrofitService: RetrofitService,
                     private val dbService: DBService
): IMaterialRepository {

    override fun getMaterial(materialRequest: MaterialRequest): Flow<List<MaterialDto>> =
        retrofitService.getMaterial(materialRequest.toRequest()).map { list ->
            list.map { value ->
                value.toDto()
            }
        }
}