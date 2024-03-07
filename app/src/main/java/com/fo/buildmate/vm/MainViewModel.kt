package com.fo.buildmate.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fo.domain.exception.MaterialException
import com.fo.domain.model.MaterialDto
import com.fo.domain.model.MaterialRequest
import com.fo.domain.usecase.GetMaterialListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
): ViewModel() {

}