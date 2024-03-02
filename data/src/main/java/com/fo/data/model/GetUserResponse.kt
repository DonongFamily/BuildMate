package com.fo.data.model

import com.fo.domain.model.UserDto

data class GetUserResponse(val uid: Int, val name: String, val id: String, val pw: String): Response<UserDto> {

    override fun toDto() =
        UserDto(
            uid = uid,
            name = name,
            id = id,
            pw = pw
        )
}