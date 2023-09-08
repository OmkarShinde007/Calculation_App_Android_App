package com.example.calculationapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/** Class used as a Room DAO. Is used to write the database query and communicate with the database. */
@Dao
interface HistoryDao {

    /** Method used to insert the data. */
    @Insert
    suspend fun insertData(historyDataClass: HistoryDataClass)

    /** Method used to get all the data. */
    @Query("SELECT * FROM history_data")
    fun getAllData(): LiveData<List<HistoryDataClass>>
}