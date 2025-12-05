package com.example.pertemuan9.view.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.repositori.AplikasiSiswa
import com.example.pertemuan9.view.viewmodel.DetailViewModel
import com.example.pertemuan9.view.viewmodel.EntryViewModel
import com.example.pertemuan9.view.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        // HomeViewModel
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        // EntryViewModel
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        // DetailViewModel (WAJIB ADA INI BIAR BISA KLIK & HAPUS)
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)