package com.example.mvvm2

import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.Anggota
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AnggotaViewModel : ViewModel() {
    private val _anggota = MutableStateFlow(Anggota())
    val anggota: StateFlow<Anggota> = _anggota

    fun setAnggota(anggota: Anggota) {
        _anggota.update { anggota }
    }
}
