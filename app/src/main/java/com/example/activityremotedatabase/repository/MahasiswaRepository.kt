package com.example.activityremotedatabase.repository

import com.example.activityremotedatabase.model.Mahasiswa
import com.example.activityremotedatabase.service.MahasiswaService
import retrofit2.Response
import java.io.IOException

interface MahasiswaRepository {
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim:String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
    suspend fun getMahasiswaByNim(nim: String):Mahasiswa
}

class NetworkMahasiswaRepository(
    private val mahasiswaApiService: MahasiswaService
) : MahasiswaService {
    override suspend fun insertMahasiswa(mahasiwa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiwa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiwa: Mahasiswa) {
        mahasiswaApiService.updateMahasiswa(nim, mahasiwa)
    }

    override suspend fun deleteMahasiswa(nim: String): Response<Void> {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful) {
                throw IOException ("Failed to delete mahasiswa. HTTP Status code: " +
                    "${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> = mahasiswaApiService. getMahasiswa()

    override suspend fun getMahasiswaByNim(nim: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswaByNim(nim)
    }
}