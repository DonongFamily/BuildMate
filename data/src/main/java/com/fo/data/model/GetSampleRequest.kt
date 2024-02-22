package com.fo.data.model

import com.fo.domain.exception.UserException
import com.fo.domain.model.SampleRequest

data class GetSampleRequest(val name: String)

fun SampleRequest.toRequest(): GetSampleRequest =
    GetSampleRequest(
        name = if(this.name.length > 3) { throw UserException() } else { this.name }
    )