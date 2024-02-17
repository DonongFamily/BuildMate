package com.fo.domain.usecase

import kotlinx.coroutines.flow.Flow

interface IUseCase<I, O> {

    suspend fun invoke(request: I): Flow<O>
}