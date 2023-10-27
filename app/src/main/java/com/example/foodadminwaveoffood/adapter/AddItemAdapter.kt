package com.example.foodadminwaveoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodadminwaveoffood.databinding.ItemItemBinding

class AddItemAdapter(
    private val MenuItemName: ArrayList<String>,
    private val MenuItemPrice: ArrayList<String>,
    private val MenuItemImage: ArrayList<Int>
) : RecyclerView.Adapter<AddItemAdapter.AddItemViewHolder>() {
    private val itemQuantities = IntArray(MenuItemName.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = MenuItemName.size
    inner class AddItemViewHolder(private val binding: ItemItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantitiy = itemQuantities[position]
                foodNametextView.text=MenuItemName[position]
                PriceTextView.text=MenuItemPrice[position]
                foodImageView.setImageResource(MenuItemImage[position])
                quantitiyTextView.text=quantitiy.toString()

                minusButton.setOnClickListener {
                    decraeseQuantitiy(position)
                }

                plusButton.setOnClickListener {
                    increaseQuantitiy(position)
                }

                deleteButton.setOnClickListener {
                    deleteQuantitiy(position)
                }
            }
        }

              private fun deleteQuantitiy(position: Int) {
              MenuItemName.removeAt(position)
              MenuItemPrice.removeAt(position)
              MenuItemImage.removeAt(position)
              itemQuantities.drop(position)
              notifyItemRemoved(position)
              notifyItemRangeChanged(position,MenuItemName.size)
        }


               private fun increaseQuantitiy(position: Int) {
               if (itemQuantities[position]<10){
                itemQuantities[position]++
                binding.quantitiyTextView.text=itemQuantities[position].toString()
            }
        }
                private fun decraeseQuantitiy(position: Int) {
                 if (itemQuantities[position]>1){
                   itemQuantities[position]--
                   binding.quantitiyTextView.text=itemQuantities[position].toString()
                }
         }
    }
}