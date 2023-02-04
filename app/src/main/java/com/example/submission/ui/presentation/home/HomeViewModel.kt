package com.example.submission.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.core.domain.usecase.VanguardUseCase
import com.example.submission.ui.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val vanguardeUseCase : VanguardUseCase
) : ViewModel(){

    private val _uiState: MutableStateFlow<UiState<List<Vanguard>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Vanguard>>>
        get() = _uiState

    init {
        getAllVanguards()
    }

    fun getAllVanguards() {
        viewModelScope.launch(Dispatchers.IO) {
            vanguardeUseCase.getAllVanguards().onEach { condition ->
                when(condition){
                    is Resource.Loading ->{}
                    is Resource.Success ->{
                        _uiState.value = UiState.Success(condition.data)
                    }
                    is Resource.Error ->{
                        _uiState.value = UiState.Error(condition.message.toString())
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}