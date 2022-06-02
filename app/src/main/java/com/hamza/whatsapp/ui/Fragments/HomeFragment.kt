package com.hamza.whatsapp.ui.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hamza.whatsapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendMessagebtn.setOnClickListener {
            val number = binding.numberEditText.text.toString()
            val message = binding.messageEditText.text.toString()

            if (number.trim().length < 8)
                Toast.makeText(context, "Please, enter correct number", Toast.LENGTH_LONG).show()
            else sendMessage(number, message)
        }
    }

    private fun sendMessage(number: String, message: String) {
        val countryCode = binding.countrySelection.selectedCountryCode.toString()
        try {

            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://api.whatsapp.com/send?phone=$countryCode$number&text=$message")
                )
            )
        } catch (e: Exception) {
            Toast.makeText(context, "whatsapp app not install", Toast.LENGTH_LONG).show()
        }
    }


}