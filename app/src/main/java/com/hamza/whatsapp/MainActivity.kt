package com.hamza.whatsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hamza.whatsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.sendMessagebtn.setOnClickListener {
            sendMessage(
                binding.numberEditText.text.toString(),
                binding.messageEditText.text.toString()
            )
            Toast.makeText(this, "sent ", Toast.LENGTH_LONG).show()
        }


    }


    private fun sendMessage(number: String, message: String) {
        try {

            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://api.whatsapp.com/send?phone=2$number&text=$message")
                )
            )
        } catch (e: Exception) {
            Toast.makeText(this, "whatsapp app not install", Toast.LENGTH_LONG).show()
        }
    }
}