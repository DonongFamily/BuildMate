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

            else -> "UNDEFINED"
        }
}