package com.example.inventory_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inventory_app.databinding.ActivityUploadBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            val itemNameIn = binding.ItemNameIn.text.toString()
            val quantityIn = binding.QuantityIn.text.toString()
            val priceIn = binding.PriceIn.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Item Information")
            val itemData = ItemData(itemNameIn, quantityIn, priceIn)

            // Get the count of existing items to determine the new key
            databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val newItemKey =
                        dataSnapshot.childrenCount + 1 // Generate unique key based on count
                    val newItemRef = databaseReference.child("ID $newItemKey")

                    newItemRef.setValue(itemData).addOnSuccessListener {
                        binding.ItemNameIn.text.clear()
                        binding.QuantityIn.text.clear()
                        binding.PriceIn.text.clear()

                        Toast.makeText(this@UploadActivity, "Saved", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@UploadActivity, UploadActivity::class.java)
                        startActivity(intent)
                        finish()

                    }.addOnFailureListener {
                        Toast.makeText(this@UploadActivity, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle error
                }
            })
        }
    }
}