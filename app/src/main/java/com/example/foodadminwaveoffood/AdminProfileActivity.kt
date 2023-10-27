package com.example.foodadminwaveoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodadminwaveoffood.databinding.ActivityAdminProfileBinding

class AdminProfileActivity : AppCompatActivity() {
    private val binding : ActivityAdminProfileBinding by lazy {
        ActivityAdminProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.name.isEnabled=true
        binding.addresh.isEnabled=true
        binding.email.isEnabled=true
        binding.phone.isEnabled=true
        binding.password0.isEnabled=true

        var isEnable = false

        binding.editButton.setOnClickListener {
            isEnable = ! isEnable
            binding.name.isEnabled=isEnable
            binding.addresh.isEnabled=isEnable
            binding.email.isEnabled=isEnable
            binding.phone.isEnabled=isEnable
            binding.password0.isEnabled=isEnable
            if (isEnable) {
                binding.name.requestFocus()
            }
        }
    }
}