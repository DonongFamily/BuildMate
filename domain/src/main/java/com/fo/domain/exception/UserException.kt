package com.fo.domain.exception

import com.fo.domain.errorcode.UserErrorCode

class UserException(val userErrorCode: UserErrorCode): Exception()