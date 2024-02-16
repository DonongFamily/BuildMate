package com.fo.data.model

interface Response<T> {
    fun toDto(): T
}