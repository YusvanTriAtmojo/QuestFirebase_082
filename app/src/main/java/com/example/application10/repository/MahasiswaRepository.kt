package com.example.application10.repository

import com.example.application10.model.Mahasiswa
import kotlinx.coroutines.flow.Flow


interface MahasiswaRepository {
    suspend fun getMahasiswa(): Flow<List<Mahasiswa>>
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String, mahasiswa: Mahasiswa)
    suspend fun getMahasiswabyNim(nim: String):Flow<Mahasiswa>
}