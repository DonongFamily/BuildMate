package com.fo.buildmate.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fo.buildmate.base.Global
import com.fo.buildmate.errormapper.UserErrorMapper
import com.fo.domain.exception.UserException
import com.fo.domain.model.UserDto
import com.fo.domain.model.UserRequest
import com.fo.domain.usecase.AddUserUseCase
import com.fo.domain.usecase.DeleteUserUseCase
import com.fo.domain.usecase.GetUserFromDBUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserFromDBUseCase: GetUserFromDBUseCase,
    private val addUserUseCase: AddUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val userErrorMapper: UserErrorMapper
) : ViewModel() {

    private val _user = MutableLiveData<UserDto?>()
    val user: LiveData<UserDto?> get() = _user

    private val _addUserResult = MutableLiveData<Unit>()
    val addUserResult: LiveData<Unit> get() = _addUserResult


    private val _deleteUserResult = MutableLiveData<Unit>()
    val deleteUserResult: LiveData<Unit> get() = _deleteUserResult


    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getUserFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getUserFromDBUseCase.invoke(Unit)
                    .retry(Global.REQUEST_MAX_COUNT)
                    .collect {
                        _user.postValue(it)
                    }
            } catch (e: Exception) {
                when (e) {
                    is UserException -> {
                        _errorMessage.postValue(userErrorMapper.toErrorMessage(e.userErrorCode))
                    }
                }
            }
        }
    }

    fun addUserToDB(request: UserRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                addUserUseCase.invoke(request)
                    .retry(Global.REQUEST_MAX_COUNT)
                    .collect {
                        _addUserResult.postValue(it)
                    }
            } catch (e: Exception) {
                when (e) {
                    is UserException -> {
                        _errorMessage.postValue(userErrorMapper.toErrorMessage(e.userErrorCode))
                    }
                }
            }
        }
    }

    fun deleteUserToDB(request: UserRequest) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                deleteUserUseCase.invoke(request)
                    .retry(Global.REQUEST_MAX_COUNT)
                    .collect {
                        _deleteUserResult.postValue(it)
                    }
            } catch (e: Exception) {
                when (e) {
                    is UserException -> {
                        _errorMessage.postValue(userErrorMapper.toErrorMessage(e.userErrorCode))
                    }
                }
            }
        }

    }
}