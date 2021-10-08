package com.example.digitalfit.modelApi

import com.example.digitalfit.modelDb.EquipmentDb

data class Equipment(
    val id: Int,
    val name: String
)

fun Equipment.toEquipmentDb(): EquipmentDb {
    return EquipmentDb(
        equipmentId = this.id,
        name = this.name
    )
}