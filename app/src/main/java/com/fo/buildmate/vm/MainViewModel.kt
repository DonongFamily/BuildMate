package com.fo.buildmate.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fo.domain.model.SampleDto
import com.fo.domain.model.SampleRequest
import com.fo.domain.usecase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sampleUseCase: SampleUseCase
): ViewModel() {

    private val _sampleData = MutableLiveData<SampleDto>()
    val sampleData: LiveData<SampleDto> get() = _sampleData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getSample() {
        viewModelScope.launch(Dispatchers.IO) {
            sampleUseCase.invoke(SampleRequest("hello")).catch {
                _errorMessage.postValue(it.message)
            }.collect {
                _sampleData.postValue(it)
            }
        }
    }
}