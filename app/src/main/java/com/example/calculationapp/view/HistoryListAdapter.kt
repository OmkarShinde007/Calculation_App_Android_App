package com.example.calculationapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculationapp.model.HistoryDataClass
import com.example.todoapp.R

/** [HistoryListAdapter] is used to provide the data to [RecyclerView]. */
class HistoryListAdapter(
    context: Context?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val todoList = ArrayList<HistoryDataClass>()
    private val context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HistoryListViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Bind the data to the recyclerview
        (holder as HistoryListViewHolder).bind(todoList[position])
    }

    /** Method used to update the list and notify the recyclerview items. */
    fun updateList(newList: List<HistoryDataClass>) {
        todoList.clear()
        todoList.addAll(newList)
        notifyDataSetChanged()
    }
}