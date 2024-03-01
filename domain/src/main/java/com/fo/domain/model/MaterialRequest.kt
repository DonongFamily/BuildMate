package com.fo.domain.model

import com.fo.domain.errorcode.Material
import com.fo.domain.exception.MaterialException

data class MaterialRequest(private val name: String) {
    fun getName(): String {
        return when {
            name.isEmpty() -> { throw MaterialException(Material.REQUEST_NAME_IS_EMPTY) }

            else -> { name }
        }
    }
}