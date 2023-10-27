package com.example.foodadminwaveoffood

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.foodadminwaveoffood.databinding.ActivityAddItemBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase

class AddItemActivity : AppCompatActivity() {
    // Food İtem Detalist
    private lateinit var foodName: String
    private lateinit var foodPrice: String
    private lateinit var foodDescriptor: String
    private var foodImageUri: Uri? = null
    private lateinit var foodIngredient: String

    //Firebase
    private lateinit var auth: FirebaseAuth
    private lateinit var database:FirebaseDatabase

    private val binding : ActivityAddItemBinding by lazy {
        ActivityAddItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // initalize FireBase
        auth = FirebaseAuth.getInstance()
        // initalize FireBase database instance
        database = FirebaseDatabase.getInstance()

        binding.addItemButton.setOnClickListener {
            // Get data from Filed
            foodName = binding.foodName.text.toString().trim()
            foodPrice = binding.foodPrice.text.toString().trim()
            foodDescriptor = binding.description.text.toString().trim()
            foodIngredient= binding.ingredint.text.toString().trim()

            if (!(foodName.isBlank() || foodPrice.isBlank() || foodDescriptor.isBlank() || foodIngredient.isBlank())) {
                uploadData()
                Toast.makeText(this, "Itemm Ad Succesfully ", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            }
            binding.selectImage.setOnClickListener {
                pickImage.launch("image/*")
            }
        }
        binding.backButton.setOnClickListener {
            finish()
        }
        }

    private fun uploadData() {
        // get a reference to the "menu"  node in the database
        val menuRef = database.getReference("menu")
        // Genrate a unique key for the new menu item
        val newItemKey = menuRef.push().key

        if (foodImageUri != null) {
            
        }
    }

   private  val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()){ uri ->
        if (uri != null)
            binding.selectedImage.setImageURI(uri)
    }
}