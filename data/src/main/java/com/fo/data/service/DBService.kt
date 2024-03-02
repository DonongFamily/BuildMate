package com.fo.data.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fo.data.dao.UserDao
import com.fo.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DBService(private val context: Context){
    private val db by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "local"
        ).build()
    }

    fun getUser(): Flow<List<UserEntity>> =
        db.userDao().getAll()

    fun addUser(userEntity: UserEntity): Flow<Boolean> {
        val result = db.userDao().insert(userEntity)
        return flow {
            emit(true)
        }
    }

    fun deleteUser(userEntity: UserEntity): Flow<Boolean> {
        val result = db.userDao().delete(userEntity)
        return flow {
            emit(result > 0)
        }
    }
}

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}