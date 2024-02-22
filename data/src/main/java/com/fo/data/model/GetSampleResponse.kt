package com.fo.data.model

import com.fo.domain.exception.UserException
import com.fo.domain.model.SampleDto

data class GetSampleResponse(val name: String): Response<SampleDto> {

    override fun toDto() =
        SampleDto(name ?: throw UserException()
    )
}