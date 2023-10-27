package com.example.foodadminwaveoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodadminwaveoffood.adapter.AddItemAdapter
import com.example.foodadminwaveoffood.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val binding : ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val menuFoodName = listOf("Burger","Sandwitch","momo","İtem","Sandwitch","momo")
        val menuItemPrice = listOf("$5","$6","$8","$9","$10","10")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu4
        )
        binding.backButton.setOnClickListener {
            finish()
        }
        val adapter = AddItemAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage)
        )
        binding.menuRecylerView.layoutManager = LinearLayoutManager(this)
        binding.menuRecylerView.adapter = adapter
    }
}