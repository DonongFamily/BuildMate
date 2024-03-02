package com.fo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fo.data.model.Response
import com.fo.domain.model.UserDto

@Entity
data class UserEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "pw") val pw: String
): Response<UserDto> {

    override fun toDto(): UserDto =
        UserDto(
            uid = uid,
            name = name,
            id = id,
            pw = pw
        )
}

fun UserDto.toEntity(): UserEntity =
    UserEntity(
        uid = uid,
        name = name,
        id = id,
        pw = pw
    )