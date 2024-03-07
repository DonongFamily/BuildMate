package com.fo.domain.model

import java.util.UUID

data class UserDto(val uid: UUID, val name: String, val id: String, val pw: String, val cash: String, val imgPath: String)