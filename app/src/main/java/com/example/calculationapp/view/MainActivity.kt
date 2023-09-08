package com.example.calculationapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.R

/** [MainActivity] is used to launch the
 * [HomeFragment]. A HomeFragment is launch using navigation i.e. [nav_graph].
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}