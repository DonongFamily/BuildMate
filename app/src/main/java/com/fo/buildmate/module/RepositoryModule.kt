package com.fo.buildmate.module

import com.fo.data.repository.ChatRepository
import com.fo.data.repository.MaterialRepository
import com.fo.data.repository.UserRepository
import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.repository.IChatRepository
import com.fo.domain.repository.IMaterialRepository
import com.fo.domain.repository.IUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(retrofitService: RetrofitService, dbService: DBService): IUserRepository {
        return UserRepository(retrofitService, dbService)
    }

    @Provides
    @Singleton
    fun provideChatRepository(retrofitService: RetrofitService, dbService: DBService): IChatRepository {
        return ChatRepository(retrofitService, dbService)
    }

    @Provides
    @Singleton
    fun provideMaterialRepository(retrofitService: RetrofitService, dbService: DBService): IMaterialRepository {
        return MaterialRepository(retrofitService, dbService)
    }
}