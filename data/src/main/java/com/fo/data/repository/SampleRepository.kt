package com.fo.data.repository

import com.fo.data.model.GetSampleResponse
import com.fo.data.service.RetrofitService
import com.fo.domain.model.SampleDto
import com.fo.domain.model.SampleRequest
import com.fo.domain.repository.ISampleRepository
import kotlinx.coroutines.flow.Flow

class SampleRepository(
    private val retrofitService: RetrofitService
): ISampleRepository {

    override fun getSample(sampleRequest: SampleRequest): Flow<SampleDto> {
        GetSampleResponse("hello").toDto()
        TODO()
    }
}