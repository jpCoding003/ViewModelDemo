package com.tops.viewmodeldemo.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {


    private val _result = MutableLiveData<String>()

    val result: LiveData<String> = _result

    fun getresult(num1: Int, num2: Int, oper: String){
        Log.i("DataGet","DataGet in View Model Num1: ${num1}   &&   Num2: ${num2}")
        Log.i("Dataset", " $oper")
        _result.value = when(oper){
            "Add"->"${num1 + num2}"
            "Sub"->"${num1 - num2}"
            "Mul"->"${num1 * num2}"
            "Div"->"${num1 / num2}"
            else->  "Enter Valid Details!!"
        }
    }
}