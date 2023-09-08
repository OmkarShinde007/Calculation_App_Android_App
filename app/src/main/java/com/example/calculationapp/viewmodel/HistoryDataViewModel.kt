package com.example.calculationapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.calculationapp.model.HistoryDatabase
import com.example.calculationapp.model.HistoryDataClass
import com.example.calculationapp.model.HistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/** [HistoryDataViewModel] used to provide the data to different views */
class HistoryDataViewModel(application: Application) : AndroidViewModel(application) {

    val allTodoDataList: LiveData<List<HistoryDataClass>>
    private val repository: HistoryRepository

    init {
        val todoDao = HistoryDatabase.getDatabase(application).getDao()
        repository = HistoryRepository(todoDao)
        allTodoDataList = repository.getAllList
    }

    /** Method used to insert the data into database. */
    fun insertTodoData(historyDataClass: HistoryDataClass) =
        viewModelScope.launch(Dispatchers.IO) { repository.insert(historyDataClass) }

}