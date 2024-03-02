package com.fo.domain.model

import com.fo.domain.errorcode.UserErrorCode
import com.fo.domain.exception.UserException

data class UserRequest(private val id: String, private val pw: String) {
    fun getId(): String {
        return when {
            id.isEmpty() -> { throw UserException(UserErrorCode.REQUEST_ID_IS_EMPTY) }
            else -> { id }
        }
    }

    fun getPw(): String {
        return when {
            pw.isEmpty() -> { throw UserException(UserErrorCode.REQUEST_PW_IS_EMPTY) }
            else -> { pw }
        }
    }
}