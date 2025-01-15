package com.example.application10.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application10.model.Mahasiswa
import com.example.application10.repository.MahasiswaRepository
import com.example.application10.ui.navigation.DestinasiDetail
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: MahasiswaRepository
) : ViewModel() {
    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM]){
        "NIM tidak Ditmukan"
    }


    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    init {
        getMhsbyNim()
    }

    // Fungsi untuk mengambil data mahasiswa berdasarkan NIM
    fun getMhsbyNim() {
        viewModelScope.launch {
            mhs.getMahasiswabyNim(_nim)
                .onStart {
                    detailUiState = DetailUiState.Loading
                }
                .catch { exception ->
                    detailUiState = DetailUiState.Error(exception)
                }
                .collect { mahasiswa ->
                    detailUiState = DetailUiState.Success(mahasiswa)
                }
        }
    }
}

sealed class DetailUiState {
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    data class Error(val message: Throwable) : DetailUiState()
    object Loading : DetailUiState()
}