package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton: Button = findViewById(R.id.buttonCalculate)
        calculateButton.setOnClickListener { calculate() }
        val resetButton: Button = findViewById(R.id.buttonReset)
        resetButton.setOnClickListener { reset() }
    }

    private fun reset() {
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        AnswerLoan.setText("")
        interest1.setText("")
        Repayment.setText("")
    }

    private fun calculate() {
        val carPrice = editTextCarPrice.text.toString().toDouble()
        val downPayemnt = editTextDownPayment.text.toString().toDouble()
        val interestRate = editTextInterestRate.text.toString().toDouble()
        val period = editTextLoanPeriod.text.toString().toDouble()
        val totalLoan = carPrice-downPayemnt
        val totalInterest = totalLoan*interestRate*period
        val totalRepayment = (totalLoan + totalInterest)/period/12

        AnswerLoan.text = String.format("%.2f", totalLoan)
        interest1.text = String.format("%.2f", totalInterest)
        Repayment.text =  String.format("%.2f", totalRepayment)
    }
}
