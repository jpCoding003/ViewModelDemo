package com.tops.viewmodeldemo.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuotesViewModel: ViewModel() {

    private var _quotes = MutableLiveData<String>()

    val quotesList = listOf<String>(
        "Your Hunger Decides Your Legacy",
        "Success is Not Accident",
        "Work Hard, Get Sucess",
        "Who the Hell Are you",
        "Your are the Beast",
        "Try to stay Focus And Stay Consistent",
        "This Mobile Android App Dev.",
        "Grind in silence, let success make the noise.",
        "Every setback is a setup for a comeback.",
        "Wake. Hustle. Repeat. No room for excuses.",
        "No handouts, just hard work and hustle daily.",
        "Hustlers don’t sleep, they recharge and reload.",
        "Discipline and drive will outwork raw talent.",
        "If you want more, hustle harder than yesterday.",
        "You don’t need luck, just relentless effort daily.",
        "Work until your idols become your competition."
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