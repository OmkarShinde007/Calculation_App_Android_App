package com.example.calculationapp.model

import androidx.lifecycle.LiveData

/** Class used to send the instruction to the ToDoDAO. */
class HistoryRepository(private val historyDao: HistoryDao) {

    // Get All the data from the database.
    val getAllList: LiveData<List<HistoryDataClass>> = historyDao.getAllData()

    /** Method used to insert the data. */
    suspend fun insert(historyDataClass: HistoryDataClass) {
        historyDao.insertData(historyDataClass)
    }
}