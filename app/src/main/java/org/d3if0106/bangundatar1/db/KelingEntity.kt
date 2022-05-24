package org.d3if0106.bangundatar1.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "keling")
data class KelingEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var jari: Float
)