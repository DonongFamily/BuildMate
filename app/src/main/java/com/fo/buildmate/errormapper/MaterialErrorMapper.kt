package com.fo.buildmate.errormapper

import android.content.Context
import com.fo.buildmate.R
import com.fo.domain.errorcode.MaterialErrorCode
import javax.inject.Inject

class MaterialErrorMapper @Inject constructor(
    private val context: Context
): IErrorMapper<MaterialErrorCode> {

    override fun toErrorMessage(errorCode: MaterialErrorCode): String =
        when(errorCode) {
            MaterialErrorCode.REQUEST_NAME_IS_EMPTY -> context.getString(R.string.MATERIAL_REQUEST_NAME_IS_EMPTY)

            else -> "UNDEFINED"
        }
}