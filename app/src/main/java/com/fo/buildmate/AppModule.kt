package com.fo.buildmate

import android.content.Context
import com.fo.buildmate.errormapper.MaterialErrorMapper
import com.fo.buildmate.vm.MaterialViewModel
import com.fo.data.repository.ChatRepository
import com.fo.data.repository.MaterialRepository
import com.fo.data.repository.UserRepository
import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.repository.IChatRepository
import com.fo.domain.repository.IMaterialRepository
import com.fo.domain.repository.IUserRepository
import com.fo.domain.usecase.GetMaterialListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideMaterialRepository(retrofitService: RetrofitService, dbService: DBService): IMaterialRepository {
        return MaterialRepository(retrofitService, dbService)
    }

    @Provides
    fun provideGetMaterialUseCase(materialRepository: IMaterialRepository): GetMaterialListUseCase {
        return GetMaterialListUseCase(materialRepository)
    }

    @Provides
    @Singleton
    fun provideMaterialErrorMapper(@ApplicationContext context: Context): MaterialErrorMapper {
        return MaterialErrorMapper(context)
    }
}
