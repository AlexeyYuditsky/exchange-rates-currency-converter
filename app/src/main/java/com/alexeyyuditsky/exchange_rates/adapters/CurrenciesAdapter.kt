package com.alexeyyuditsky.exchange_rates.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.exchange_rates.databinding.ItemCurrencyBinding
import com.alexeyyuditsky.exchange_rates.model.Currency

class CurrenciesAdapter : RecyclerView.Adapter<CurrenciesAdapter.CurrencyViewHolder>() {

    var currencies: List<Currency> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCurrencyBinding.inflate(inflater, parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = currencies[position]
        holder.binding.apply {
            currencyName.text = currency.name
            currencyValue.text = currency.value.toString()
        }
    }

    override fun getItemCount(): Int = currencies.size

    class CurrencyViewHolder(val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root)

}