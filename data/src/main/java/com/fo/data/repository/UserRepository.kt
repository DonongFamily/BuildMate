package com.fo.data.repository

import com.fo.data.model.GetSampleResponse
import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.model.SampleDto
import com.fo.domain.model.SampleRequest
import com.fo.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class UserRepository(private val retrofitService: RetrofitService,
    private val dbService: DBService
): IUserRepository {

    override fun getSample(sampleRequest: SampleRequest): Flow<SampleDto> {
        GetSampleResponse("hello").toDto()
        TODO()
    }
}