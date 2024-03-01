package com.fo.buildmate.errormapper

import android.content.Context
import com.fo.buildmate.R
import com.fo.domain.errorcode.Material
import javax.inject.Inject

class MaterialErrorMapper @Inject constructor(
    private val context: Context
): IErrorMapper<Material> {

    override fun toErrorMessage(enum: Material): String =
        when(enum) {
            Material.REQUEST_NAME_IS_EMPTY -> context.getString(R.string.MATERIAL_REQUEST_NAME_IS_EMPTY)

            else -> "UNDEFINED"
        }
}