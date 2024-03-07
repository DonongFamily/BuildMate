package com.fo.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fo.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM userentity")
    fun getAllUser(): List<UserEntity>

    @Query("SELECT * FROM userentity LIMIT 1")
    fun getUser(): Flow<UserEntity?>

    @Insert
    fun insert(vararg userEntity: UserEntity): List<Long>

    @Delete
    fun delete(userEntity: UserEntity): Int
}
