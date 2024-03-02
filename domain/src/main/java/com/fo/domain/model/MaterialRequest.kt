package com.fo.domain.model

import com.fo.domain.errorcode.MaterialErrorCode
import com.fo.domain.exception.MaterialException

data class MaterialRequest(private val name: String) {
    fun getName(): String {
        return when {
            name.isEmpty() -> { throw MaterialException(MaterialErrorCode.REQUEST_NAME_IS_EMPTY) }

            else -> { name }
        }
    }
}