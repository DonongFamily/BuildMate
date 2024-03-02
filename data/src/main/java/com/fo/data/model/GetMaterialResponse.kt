package com.fo.data.model

import com.fo.domain.errorcode.MaterialErrorCode
import com.fo.domain.exception.MaterialException
import com.fo.domain.model.MaterialDto


data class GetMaterialResponse(val name: String, val detail: String, val price: Int): Response<MaterialDto> {

    override fun toDto() =
        MaterialDto(
            name = if(this.name.length > 3) { throw MaterialException(MaterialErrorCode.RESPONSE_NAME_IS_EMPTY) } else { this.name },
            detail = detail,
            price = price
        )
}