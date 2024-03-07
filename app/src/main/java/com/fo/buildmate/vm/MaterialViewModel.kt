package com.fo.buildmate.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fo.buildmate.base.Global
import com.fo.buildmate.errormapper.MaterialErrorMapper
import com.fo.domain.exception.MaterialException
import com.fo.domain.model.MaterialDto
import com.fo.domain.model.MaterialRequest
import com.fo.domain.usecase.GetMaterialListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MaterialViewModel @Inject constructor(
    private val getMaterialListUseCase: GetMaterialListUseCase,
    private val materialErrorMapper: MaterialErrorMapper
): ViewModel() {

    private val _materialList = MutableLiveData<List<MaterialDto>>()
    val materialList: LiveData<List<MaterialDto>> get() = _materialList


    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getMaterialList(materialRequest: MaterialRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getMaterialListUseCase.invoke(materialRequest)
                    .retry(Global.REQUEST_MAX_COUNT)
                    .collect {
                        _materialList.postValue(it)
                    }
            } catch (e: Exception) {
                when(e) {
                    is MaterialException -> {
                        _errorMessage.postValue(materialErrorMapper.toErrorMessage(e.materialErrorCode))
                    }
                    else -> {

                    }
                }
            }
        }
    }
}