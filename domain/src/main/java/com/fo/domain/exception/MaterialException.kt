package com.fo.domain.exception

import com.fo.domain.errorcode.Material

class MaterialException(val material: Material): Exception()