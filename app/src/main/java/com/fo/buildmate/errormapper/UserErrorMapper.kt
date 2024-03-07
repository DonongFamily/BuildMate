package com.fo.buildmate.errormapper

import android.content.Context
import com.fo.buildmate.R
import com.fo.domain.errorcode.UserErrorCode
import javax.inject.Inject

class UserErrorMapper @Inject constructor(
    private val context: Context
): IErrorMapper<UserErrorCode> {

    override fun toErrorMessage(errorCode: UserErrorCode): String =
        when(errorCode) {
            UserErrorCode.REQUEST_ID_IS_EMPTY -> context.getString(R.string.USER_REQUEST_ID_IS_EMPTY)
            UserErrorCode.REQUEST_PW_IS_EMPTY -> context.getString(R.string.USER_REQUEST_PW_IS_EMPTY)
            UserErrorCode.REQUEST_NAME_IS_EMPTY -> context.getString(R.string.USER_REQUEST_NAME_IS_EMPTY)
            UserErrorCode.INSERT_ERROR -> context.getString(R.string.USER_INSERT_ERROR)
            UserErrorCode.DELETE_ERROR -> context.getString(R.string.USER_DELETE_ERROR)
            UserErrorCode.SELECT_ERROR -> context.getString(R.string.USER_SELECT_ERROR)
            else -> "UNDEFINED"
        }
}