package com.fo.data.repository

import com.fo.data.service.DBService
import com.fo.data.service.RetrofitService
import com.fo.domain.repository.IChatRepository

class ChatRepository(private val retrofitService: RetrofitService,
    private val dbService: DBService
    ): IChatRepository {

}