package com.fo.domain.exception

import com.fo.domain.errorcode.MaterialErrorCode

class MaterialException(val materialErrorCode: MaterialErrorCode): Exception()