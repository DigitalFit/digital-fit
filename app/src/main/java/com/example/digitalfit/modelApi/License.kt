package com.example.digitalfit.modelApi

import com.example.digitalfit.modelDb.LicenseDb

data class License(
    val id: Int,
    val full_name: String,
    val short_name: String,
    val url: String
)

fun License.toLicenseDb(): LicenseDb {
    return LicenseDb(
        licenseId = this.id,
        full_name = this.full_name,
        short_name = this.short_name,
        url = this.url
    )
}