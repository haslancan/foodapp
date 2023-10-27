package com.example.foodadminwaveoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodadminwaveoffood.adapter.DeliveryAdapter
import com.example.foodadminwaveoffood.adapter.PendingOrderAdapter
import com.example.foodadminwaveoffood.databinding.ActivityPendingOrderBinding
import com.example.foodadminwaveoffood.databinding.PendingOrderItemBinding

class PendingOrderActivity : AppCompatActivity() {

    private lateinit var binding :ActivityPendingOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }

        val orderCuostomerName = arrayListOf(
            "John Doe",
            "Jane Smith",
            "Mike Jahnson",
        )
        val orderedQuantitiy = arrayListOf(
            "8",
            "6",
            "5",
        )
        val orderedFoodImage = arrayListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3)
        val adapter = PendingOrderAdapter(orderCuostomerName, orderedQuantitiy,orderedFoodImage,this    )
        binding.PendingOrderRecylerView.adapter = adapter
        binding.PendingOrderRecylerView.layoutManager = LinearLayoutManager(this)
    }
}