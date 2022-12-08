package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val counter = findViewById<TextView>(R.id.tt)
        val countButton = findViewById<TextView>(R.id.bt)
        //counter.text = count.toString()
        counter.text = viewModel.count.toString()

        countButton.setOnClickListener {
           // count++
          //  counter.text = count.toString()
            viewModel.updateCount()
            counter.text = viewModel.count.toString()
        }
    }
}