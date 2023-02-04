package com.example.submission.ui.utils

import com.example.submission.core.domain.model.Vanguard

sealed class UiState<out T: Any?> {

    object Loading : UiState<Nothing>()

    data class Success<out T: Any>(val data: List<Vanguard>?) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}