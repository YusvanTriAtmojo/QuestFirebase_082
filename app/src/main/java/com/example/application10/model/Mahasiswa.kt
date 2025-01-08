package com.example.application10.model

data class Mahasiswa (
    val nim: String,
    val nama: String,
    val jenisKelamin: String,
    val alamat: String,
    val kelas: String,
    val angkatan: String
) {
    constructor():this("", "", "", "", "", "")
}
