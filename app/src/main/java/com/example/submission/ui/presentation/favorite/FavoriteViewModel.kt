package com.example.submission.ui.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.core.domain.usecase.VanguardUseCase
import com.example.submission.ui.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel  @Inject constructor(
    private val vanguardeUseCase : VanguardUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<Vanguard>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Vanguard>>
        get() = _uiState

    init {
        favoriteVanguards()
    }

    fun favoriteVanguards() {
        viewModelScope.launch(Dispatchers.IO) {
            vanguardeUseCase.getFavoriteVanguard()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }.collect{
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}