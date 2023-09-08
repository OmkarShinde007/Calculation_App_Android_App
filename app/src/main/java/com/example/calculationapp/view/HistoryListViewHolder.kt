package com.example.calculationapp.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.calculationapp.model.HistoryDataClass
import com.example.todoapp.R
import com.google.android.material.textview.MaterialTextView

/** [HistoryListViewHolder] is used to bind the recyclerview items. */
class HistoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleText: MaterialTextView = itemView.findViewById(R.id.title_text)
    private val timeText: MaterialTextView = itemView.findViewById(R.id.time_text)

    fun bind(
        historyDataClass: HistoryDataClass
    ) {
        titleText.text = historyDataClass.title
        timeText.text = historyDataClass.dateAndTime
    }
}