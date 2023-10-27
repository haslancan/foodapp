package com.example.foodadminwaveoffood.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodadminwaveoffood.databinding.PendingOrderItemBinding

class PendingOrderAdapter(private val customrNames:ArrayList<String>,
     private val quantitiy:ArrayList<String>,
     private val foodImage:ArrayList<Int>,
     private val context: Context) : RecyclerView.Adapter<PendingOrderAdapter.PendingOrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingOrderViewHolder {
        val binding = PendingOrderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  PendingOrderViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PendingOrderViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = customrNames.size
    inner class PendingOrderViewHolder(private val binding: PendingOrderItemBinding):RecyclerView.ViewHolder(binding.root) {
        private var isAccepted = false
        fun bind(position: Int) {
            binding.apply {
                costomerName.text = customrNames[position]
                PendingOrderQuantitiy.text =quantitiy[position]
                orderFoodImage.setImageResource(foodImage[position])

                orderedAcceptButton.apply {
                    if (!isAccepted) {
                        text = "Accept"
                    } else {
                        text = "Dispatch"
                    }
                    setOnClickListener {
                      if (!isAccepted) {
                          text = "Dispatch"
                           isAccepted = true
                          showToast("Order is accepted")
                      } else {
                          customrNames.removeAt(adapterPosition)
                          notifyItemRemoved(adapterPosition)
                          showToast("Order Is dispatched")
                        }
                    }
                }
            }

         }
       private  fun showToast(messege:String) {
            Toast.makeText(context,messege,Toast.LENGTH_SHORT).show()
        }
    }
}