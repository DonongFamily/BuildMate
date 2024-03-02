package com.fo.buildmate.module

import android.content.Context
import com.fo.buildmate.errormapper.MaterialErrorMapper
import com.fo.buildmate.errormapper.UserErrorMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ErrorMapperModule {
    @Provides
    @Singleton
    fun provideMaterialErrorMapper(@ApplicationContext context: Context): MaterialErrorMapper {
        return MaterialErrorMapper(context)
    }

    @Provides
    @Singleton
    fun provideUserErrorMapper(@ApplicationContext context: Context): UserErrorMapper {
        return UserErrorMapper(context)
    }
}