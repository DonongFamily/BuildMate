package com.fo.data.service

import com.fo.data.model.GetMaterialRequest
import com.fo.data.model.GetMaterialResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RetrofitService {

    fun getMaterial(getMaterialRequest: GetMaterialRequest): Flow<List<GetMaterialResponse>> =  flow {
        //TODO: Sample Code
        val sample = listOf(GetMaterialResponse("이름", "디테일", 1000))
        emit(sample)
    }
}