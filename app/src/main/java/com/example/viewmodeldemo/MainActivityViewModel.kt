package com.example.viewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

   // var count = 0 // this is for the view model without mutable live data

    // mutable live data is a live data that can be changed
    var count = MutableLiveData<Int>() // this is for the view model with mutable live data

    // we need to initialize the mutable live data
    init {
        count.value = 0
    }

    fun updateCount() {
     //   ++count
     // this is how we change the value of mutable live data
    count.value = (count.value)?.plus(1)
    }
}