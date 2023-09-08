package com.example.calculationapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class MathApiRequest(val expr: List<String>)

data class MathApiResponse(val result: List<Double>)

/** Data Class used to hold the data and create the room table. */
@Entity(tableName = "history_data")
data class HistoryDataClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val dateAndTime: String,
)
