package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // provider is a factory that creates view models
        // we need to pass the view model class and the view model factory
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val counter = findViewById<TextView>(R.id.tt)
        val countButton = findViewById<TextView>(R.id.bt)
        //counter.text = count.toString()
        // counter.text = viewModel.count.toString()


        // we need to pass an observer to the mutable live data
        // the observer is an interface that has a method called onChanged
        // this method is called when the value of the mutable live data changes
        // the onChanged method takes the new value of the mutable live data as a parameter
        // the onChanged method is called on the main thread


       // counter.text = viewModel.count.toString() // this is for the view model without mutable live data

        viewModel.count.observe(this, Observer { // this is for the view model with mutable live data
            // "it" is the new value of the mutable live data
            counter.text = it.toString()
        })

        countButton.setOnClickListener {
            // count++
            //  counter.text = count.toString()

            // after observing the mutable live data we don't need to update the text view
            viewModel.updateCount()

            //counter.text = viewModel.count.toString()
        }
    }
}