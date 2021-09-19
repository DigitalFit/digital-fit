package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.License

@Dao
interface LicenseDao {

    @Query("SELECT * FROM license")
    suspend fun getAllLicense(): List<License>

    @Query("SELECT * FROM license WHERE licenseId = :licenseId")
    suspend fun loadLicenseById (licenseId: Int): List<License>

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExerciseWithLicense(): List<License>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLicenses (licensesList: List<License>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLicense (license: License)

    @Delete
    suspend fun delete(license: License)
}