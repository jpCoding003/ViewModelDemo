package com.tops.viewmodeldemo.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tops.viewmodeldemo.R
import com.tops.viewmodeldemo.ViewModels.CalcViewModel
import com.tops.viewmodeldemo.databinding.FragmentCalCBinding

class CalCFragment : Fragment() {

private lateinit var binding: FragmentCalCBinding
private val calcviewmodel: CalcViewModel by viewModels()
    lateinit var oper: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalCBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calcviewmodel.result.observe(viewLifecycleOwner, Observer{
            r-> binding.tvresult.text = "Ans: $r"
        })


        binding.btnAdd.setOnClickListener {

            InputAndCalc("Add")
        }

        binding.btnSub.setOnClickListener {

            InputAndCalc("Sub")
        }

        binding.btnMul.setOnClickListener {

            InputAndCalc("Mul")
        }

        binding.btnDiv.setOnClickListener {

            InputAndCalc("Div")
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_calCFragment_to_thoughtFragment)
        }
    }

    private fun InputAndCalc(oper: String){
        val num1 = binding.etNum1.text.toString()
        val num2= binding.etNum2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()){
            binding.tvresult.setText(" Please fill both Input Fields")
        }

        if (oper == "Div" && num2 == "0"){
            binding.tvresult.setText(" Can't Divisible by Zero!!")
            return
        }


        calcviewmodel.getresult(num1.toInt(),num2.toInt(),oper)
        binding.etNum1.text?.clear()
        binding.etNum2.text?.clear()
    }
}