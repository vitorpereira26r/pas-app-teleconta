package com.example.firstapp_tutorial.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.firstapp_tutorial.entities.PaidBilling
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp_tutorial.R

class PaidBillingAdapter(private val billings: List<PaidBilling>) :
    RecyclerView.Adapter<PaidBillingAdapter.PaidBillingViewHolder>() {

    class PaidBillingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val finishDate: TextView = itemView.findViewById(R.id.paidBillingFinishDate)
        val value: TextView = itemView.findViewById(R.id.valuePaidBilling)
        val paidDate: TextView = itemView.findViewById(R.id.paidBillingPaidDate)
        val paidValue: TextView = itemView.findViewById(R.id.paidBillingPaidValue)
        val feeValue: TextView = itemView.findViewById(R.id.paidBillingFeeValue)
        val idTerminal: TextView = itemView.findViewById(R.id.paidBillingIdTerminal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaidBillingAdapter.PaidBillingViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.paid_billing_item, parent, false)
        return PaidBillingAdapter.PaidBillingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PaidBillingAdapter.PaidBillingViewHolder, position: Int) {
        val billing = billings[position]

        holder.finishDate.text = billing.vencDate
        holder.value.text = "${billing.value}"
        holder.paidDate.text = billing.dataQuit
        holder.paidValue.text = "${billing.paidValue}"
        holder.feeValue.text = "${billing.feesValue}"
        holder.idTerminal.text = billing.idTerminal
    }

    override fun getItemCount(): Int {
        return billings.size
    }
}