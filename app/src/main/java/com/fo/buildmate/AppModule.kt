package com.fo.buildmate

import com.fo.buildmate.vm.MainViewModel
import com.fo.data.repository.SampleRepository
import com.fo.data.service.RetrofitService
import com.fo.domain.repository.ISampleRepository
import com.fo.domain.usecase.SampleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitService(): RetrofitService {
        return RetrofitService()
    }

    @Provides
    fun provideSampleRepository(retrofitService: RetrofitService): ISampleRepository {
        return SampleRepository(retrofitService)
    }

    @Provides
    fun provideSampleUseCase(sampleRepository: ISampleRepository): SampleUseCase {
        return SampleUseCase(sampleRepository)
    }

    @Provides
    fun provideMainViewModel(sampleUseCase: SampleUseCase): MainViewModel {
        return MainViewModel(sampleUseCase)
    }
}
