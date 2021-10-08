package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.LicenseDb
import com.example.digitalfit.modelDb.LicenseWithExercises

@Dao
interface LicenseDao {

    @Query("SELECT * FROM license")
    suspend fun getAllLicense(): List<LicenseDb>

    @Query("SELECT * FROM license WHERE licenseId = :licenseId")
    suspend fun loadLicenseById (licenseId: Int): List<LicenseDb>

    @Transaction
    @Query("SELECT * FROM license")
    fun getExerciseWithLicense(): List<LicenseWithExercises>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLicenses (licensesList: List<LicenseDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLicense (license: LicenseDb)

    @Delete
    suspend fun delete(license: LicenseDb)
}