package com.fo.buildmate.module


import com.fo.domain.repository.IMaterialRepository
import com.fo.domain.usecase.GetMaterialListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MaterialUseCaseModule {

    @Provides
    fun provideGetMaterialUseCase(materialRepository: IMaterialRepository): GetMaterialListUseCase {
        return GetMaterialListUseCase(materialRepository)
    }
}