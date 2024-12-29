package com.example.activityremotedatabase.ui.viewmodel

import com.example.activityremotedatabase.model.Mahasiswa


fun Mahasiswa.toInsertUiEvent(): InsertUiEvent = InsertUiEvent (
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)