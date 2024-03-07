package com.fo.buildmate.errormapper

interface IErrorMapper<T> {

    fun toErrorMessage(errorCode: T): String
}
