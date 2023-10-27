package com.example.foodadminwaveoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodadminwaveoffood.databinding.ActivityCreateUserBinding

class create_user_activity : AppCompatActivity() {
    private val binding : ActivityCreateUserBinding by lazy {
        ActivityCreateUserBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}