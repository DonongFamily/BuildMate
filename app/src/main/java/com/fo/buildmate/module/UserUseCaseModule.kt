package com.fo.buildmate.module


import com.fo.domain.repository.IUserRepository
import com.fo.domain.usecase.AddUserUseCase
import com.fo.domain.usecase.DeleteUserUseCase
import com.fo.domain.usecase.GetUserFromDBUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserUseCaseModule {

    @Provides
    fun provideGetUserFromDBUseCase(userRepository: IUserRepository): GetUserFromDBUseCase {
        return GetUserFromDBUseCase(userRepository)
    }
    @Provides
    fun provideAddUserUseCase(userRepository: IUserRepository): AddUserUseCase {
        return AddUserUseCase(userRepository)
    }

    @Provides
    fun provideDeleteUserUseCase(userRepository: IUserRepository): DeleteUserUseCase {
        return DeleteUserUseCase(userRepository)
    }
}