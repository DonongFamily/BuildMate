package com.fo.domain.repository

import com.fo.domain.model.SampleDto
import com.fo.domain.model.SampleRequest
import kotlinx.coroutines.flow.Flow

interface ISampleRepository {

    fun getSample(sampleRequest: SampleRequest): Flow<SampleDto>
}