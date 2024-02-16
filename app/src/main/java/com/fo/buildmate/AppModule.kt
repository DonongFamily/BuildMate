package com.fo.buildmate

import com.fo.buildmate.vm.MainViewModel
import com.fo.data.repository.ChatRepository
import com.fo.data.repository.UserRepository
import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.repository.IChatRepository
import com.fo.domain.repository.IUserRepository
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
    @Singleton
    fun provideDBService(): DBService {
        return DBService()
    }

    @Provides
    fun provideUserRepository(retrofitService: RetrofitService, dbService: DBService): IUserRepository {
        return UserRepository(retrofitService, dbService)
    }

    @Provides
    fun provideChatRepository(retrofitService: RetrofitService, dbService: DBService): IChatRepository {
        return ChatRepository(retrofitService, dbService)
    }

    @Provides
    fun provideSampleUseCase(userRepository: IUserRepository): SampleUseCase {
        return SampleUseCase(userRepository)
    }

    @Provides
    fun provideMainViewModel(sampleUseCase: SampleUseCase): MainViewModel {
        return MainViewModel(sampleUseCase)
    }
}
