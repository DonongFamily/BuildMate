package com.fo.data.model

import com.fo.domain.model.UserRequest

data class GetUserRequest(val id: String, val pw: String)

fun UserRequest.toRequest(): GetUserRequest =
    GetUserRequest(
        id = getId(),
        pw = getPw()
    )