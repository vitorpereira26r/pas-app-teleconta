package com.example.firstapp_tutorial.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp_tutorial.R
import com.example.firstapp_tutorial.adapters.PaidBillingAdapter
import com.example.firstapp_tutorial.entities.PaidBilling
import com.example.firstapp_tutorial.managers.PaidBillingsManager

class PaidBillingsActivity: AppCompatActivity(), PaidBillingsManager.PaidBillingsCallBack {

    private lateinit var paidBillingsManager: PaidBillingsManager
    private lateinit var billings: List<PaidBilling>
    private lateinit var backBtn: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_main)

        initializeViews()
        val cpf = intent.getStringExtra("CPF_EXTRA")
        if(cpf != null) {
            paidBillingsManager.getPaidBillings(cpf)
        }
    }

    private fun initializeViews() {
        backBtn = findViewById(R.id.backBtnOpenBillings)
        paidBillingsManager = PaidBillingsManager(this)
        errorTextView = findViewById(R.id.errorOpenBilling)
        recyclerView = findViewById(R.id.openBillingsList)

        backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            finish()
        }
    }

    override fun onSuccess(billings: List<PaidBilling>) {
        this.billings = billings
        displayBillings()
    }

    override fun onFailure(errorMessage: String) {
        errorTextView.text = errorMessage
    }

    private fun displayBillings() {
        val adapter = PaidBillingAdapter(billings)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}