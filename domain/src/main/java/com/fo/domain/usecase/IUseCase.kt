package com.fo.domain.usecase

interface IUseCase<I, O> {

    suspend fun invoke(request: I): Result<O>
}