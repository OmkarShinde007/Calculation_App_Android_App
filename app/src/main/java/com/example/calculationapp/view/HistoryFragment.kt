package com.example.calculationapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculationapp.viewmodel.HistoryDataViewModel
import com.example.todoapp.R
import com.google.android.material.appbar.MaterialToolbar

class HistoryFragment : Fragment() {

    private lateinit var todoListRecyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: HistoryListAdapter
    private lateinit var viewModel: HistoryDataViewModel
    private lateinit var topAppBar: MaterialToolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        todoListRecyclerView = view.findViewById(R.id.history_recyclerview)
        todoListRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerViewAdapter = HistoryListAdapter(context)
        topAppBar = view.findViewById(R.id.topAppBar)
        topAppBar.title = "Calculation History"
        topAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        // Attach the adapter to the recyclerview
        todoListRecyclerView.adapter = recyclerViewAdapter
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[HistoryDataViewModel::class.java]

        // on below line we are calling all notes method
        // from our view modal class to observer the changes on list.
        viewModel.allTodoDataList.observe(requireActivity(), Observer { list ->
            list?.let {
                // on below line we are updating our list.
                recyclerViewAdapter.updateList(it)
            }
        })
        return view
    }
}