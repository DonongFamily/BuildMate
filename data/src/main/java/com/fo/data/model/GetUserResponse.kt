package com.fo.data.model

import com.fo.domain.model.UserDto
import java.util.UUID

data class GetUserResponse(val uid: UUID, val name: String, val id: String, val pw: String, val cash: String): Response<UserDto> {

    override fun toDto() =
        UserDto(
            uid = uid,
            name = name,
            id = id,
            pw = pw,
            cash = cash
        )
}