package com.fo.data.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fo.data.dao.UserDao
import com.fo.data.entity.UserEntity
import com.fo.domain.errorcode.UserErrorCode
import com.fo.domain.exception.UserException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DBService(private val context: Context){
    private val db by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "local"
        ).build()
    }

    fun getUser(): Flow<UserEntity> {
        val result = db.userDao().getUser().firstOrNull()
        result ?: throw UserException(UserErrorCode.SELECT_ERROR)
        return flow {
            emit(result)
        }
    }

    fun addUser(userEntity: UserEntity): Flow<Unit> {
        val result = db.userDao().insert(userEntity).firstOrNull()
        result ?: throw UserException(UserErrorCode.INSERT_ERROR)
        if(result != 1L) {
            throw UserException(UserErrorCode.INSERT_ERROR)
        }
        return flow {
            emit(Unit)
        }
    }
    fun deleteUser(userEntity: UserEntity): Flow<Unit> {
        val result = db.userDao().delete(userEntity)
        if(result == 0) {
            throw UserException(UserErrorCode.DELETE_ERROR)
        }
        return flow {
            emit(Unit)
        }
    }
}

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}