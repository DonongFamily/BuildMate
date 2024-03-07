package com.fo.data.model

import com.fo.domain.model.MaterialRequest

data class GetMaterialRequest(val name: String)

fun MaterialRequest.toRequest(): GetMaterialRequest =
    GetMaterialRequest(
        name = getName()
    )