package com.fo.buildmate.errormapper

interface IErrorMapper<T> {

    fun toErrorMessage(enum: T): String
}
