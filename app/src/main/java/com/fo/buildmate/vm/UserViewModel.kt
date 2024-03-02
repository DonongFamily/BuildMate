package com.fo.buildmate.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fo.buildmate.errormapper.UserErrorMapper
import com.fo.domain.exception.MaterialException
import com.fo.domain.model.UserDto
import com.fo.domain.usecase.GetUserFromDBUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserFromDBUseCase: GetUserFromDBUseCase,
    private val userErrorMapper: UserErrorMapper
): ViewModel() {

    private val _user = MutableLiveData<UserDto>()
    val user: LiveData<UserDto> get() = _user


    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

//    fun getUserFromDB() {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                getUserFromDBUseCase.invoke()
//                    .retry(3)
//                    .collect {
//                        _user.postValue(it)
//                    }
//            } catch (e: Exception) {
//                when(e) {
//                    is MaterialException -> {
//                        _errorMessage.postValue(materialErrorMapper.toErrorMessage(e.materialErrorCode))
//                    }
//                    else -> {
//
//                    }
//                }
//            }
//        }
//    }
}