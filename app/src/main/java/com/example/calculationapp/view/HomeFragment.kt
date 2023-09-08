package com.example.calculationapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calculationapp.model.MathApiRequest
import com.example.calculationapp.model.MathApiResponse
import com.example.calculationapp.model.HistoryDataClass
import com.example.calculationapp.viewmodel.HistoryDataViewModel
import com.example.todoapp.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import retrofit2.Call
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** Fragment used to display home page of the app. */
class HomeFragment : Fragment() {

    private lateinit var viewModel: HistoryDataViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val expressionInputText: TextInputEditText = view.findViewById(R.id.expressionInput)
        val fetchResultButton: MaterialButton = view.findViewById(R.id.calculateResultButton)
        val resultLayout: CardView = view.findViewById(R.id.resultLayout)
        val topAppBar: MaterialToolbar = view.findViewById(R.id.topAppBar)

        topAppBar.title = "Calculation App"
        topAppBar.setNavigationIcon(R.drawable.baseline_cyclone_24)
        fetchResultButton.setOnClickListener {
            getData(expressionInputText.text.toString(), view)
            resultLayout.visibility = View.VISIBLE
        }

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[HistoryDataViewModel::class.java]

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
        return view
    }

    private fun getData(expressionText: String, view: View) {
        // Split the input text into lines
        val expressionOutput: MaterialTextView = view.findViewById(R.id.displayResult)
        val expressionLines = expressionText.split("\n")

        // Trim each line to remove leading/trailing whitespace
        val expressions = expressionLines.map { it.trim() }
        val mathApiService = RetrofitClient.mathApiService
        val request = MathApiRequest(expressions)
        var temp = ""
        val call = mathApiService.evaluateMathExpressions(request)
        call.enqueue(object : retrofit2.Callback<MathApiResponse> {
            override fun onResponse(
                call: Call<MathApiResponse>,
                response: retrofit2.Response<MathApiResponse>
            ) {
                if (response.isSuccessful) {
                    val mathResponse = response.body()
                    val results222 = mathResponse?.result ?: emptyList() // Handle empty results

                    for (i in results222.indices) {
                        temp = "$temp \n ${expressions[i]} = ${results222[i]}"
                    }
                    expressionOutput.text = temp
                    val sdf = SimpleDateFormat("E, dd MMM yyyy HH:mm", Locale.getDefault())
                    val currentDateAndTime: String = sdf.format(Date())
                    insertData(temp, currentDateAndTime)
                    // Handle the results (list of Double values)
                } else {
                    // Handle API error
                    val errorBody = response.errorBody()?.string()
                    Log.e("API_ERROR", "HTTP ${response.code()}: $errorBody")
                    Toast.makeText(context, "API error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<MathApiResponse>, error: Throwable) {
                // Handle network failure
                Log.e("ERROR", "HTTP $error")
                Toast.makeText(context, "Unable to fetch the result", Toast.LENGTH_SHORT).show()

            }
        })

    }

    private fun insertData(result: String, dateAndTime: String) {
        viewModel.insertTodoData(HistoryDataClass(0, result, dateAndTime))
    }
}