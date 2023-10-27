package com.example.foodadminwaveoffood

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodadminwaveoffood.databinding.ActivitySignUpBinding
import com.example.foodadminwaveoffood.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.UUID

class SignUpActivity : AppCompatActivity() {
    private lateinit var userName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var nameOfRestaurent: String
    private lateinit var auth: FirebaseAuth
    private lateinit var dataBase: DatabaseReference
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // initialize FireBase Auth
        auth = Firebase.auth
        // initialize FireBase database
        dataBase = Firebase.database.reference

        binding.createUserButton.setOnClickListener {
            // get text from EditText
            userName = binding.name.text.toString().trim()
            nameOfRestaurent = binding.restorentName.text.toString().trim()
            email = binding.emailPhone.text.toString().trim()
            password = binding.password.text.toString().trim()

            if (userName.isBlank() || nameOfRestaurent.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            } else {
                createAccount(email, password)
            }
        }

        binding.alreadyhaveaccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val locationList = arrayOf("Lahmacun", "Pizza", "Makarna", "Pide")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                println("database çalıştı1")
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                saveUserData()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                println("database çalışmadı")
                Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_SHORT).show()
                Log.d("Account", "createAccount: Failure ", task.exception)
            }
        }
    }

    // save data in to database
    private fun saveUserData() {

        // EditText'ten metni al
        val userName = binding.name.text.toString().trim()
        val nameOfRestaurant = binding.restorentName.text.toString().trim()
        val email = binding.emailPhone.text.toString().trim()
        val password = binding.password.text.toString().trim()

        // UserModel oluştur
        val user = UserModel(userName, nameOfRestaurant, email, password)

        // Firebase kullanıcısının UID'sini al
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        // UID varsa veritabanına kullanıcı verisini kaydet
        dataBase.child("User/${userId}").setValue(user)
    }
}
