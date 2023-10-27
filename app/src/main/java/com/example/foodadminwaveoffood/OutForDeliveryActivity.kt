package com.example.foodadminwaveoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodadminwaveoffood.adapter.DeliveryAdapter
import com.example.foodadminwaveoffood.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {
    private val binding : ActivityOutForDeliveryBinding by lazy {
        ActivityOutForDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }

        val cuostomerName = arrayListOf(
            "John Doe",
            "Jane Smith",
            "Mike Jahnson",
        )
        val moneyStatus = arrayListOf(
            "received",
            "notReceived",
            "Pending",
        )
        val adapter = DeliveryAdapter(cuostomerName,moneyStatus)
        binding.deliveryRecylerView.adapter = adapter
        binding.deliveryRecylerView.layoutManager = LinearLayoutManager(this)
    }
}