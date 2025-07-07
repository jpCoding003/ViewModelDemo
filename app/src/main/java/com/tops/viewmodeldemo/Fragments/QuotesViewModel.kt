package com.tops.viewmodeldemo.Fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class QuotesViewModel: ViewModel() {

    private var _quotes = MutableLiveData<String>()

    val quotesList = listOf<String>(
        "Your Hunger Decides Your Legacy",
        "Success is Not Accident",
        "Work Hard, Get Sucess",
        "Who the Hell Are you",
        "Your are the Beast",
        "Try to stay Focus And Stay Consistent",
        "This Mobile Android App Dev."
    )

    val quotes: LiveData<String> = _quotes

//    init {
//        _quotes = quotesList[0]
//    }

    fun randomGenerate(){
    val result = quotesList.random()
    _quotes.value = result
    }
}