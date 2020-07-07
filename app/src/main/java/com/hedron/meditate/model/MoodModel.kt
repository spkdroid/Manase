package com.hedron.meditate.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MoodModel(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "type") var type: String?,
    @ColumnInfo(name = "date") var date: String?,
    @ColumnInfo(name = "description") var description: String?
)