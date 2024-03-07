package com.fo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fo.data.model.Response
import com.fo.domain.model.UserDto
import com.fo.domain.model.UserRequest
import java.util.UUID

@Entity
data class UserEntity(
    @PrimaryKey val uid: UUID,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "pw") val pw: String,
    @ColumnInfo(name = "cash") val cash: String
): Response<UserDto> {

    override fun toDto(): UserDto =
        UserDto(
            uid = uid,
            name = name,
            id = id,
            pw = pw,
            cash = cash
        )
}

fun UserRequest.toEntity(): UserEntity =
    UserEntity(
        uid = UUID.randomUUID(),
        name = getName(),
        id = getId(),
        pw = getPw(),
        cash = getCash()
    )