package com.sandev.libraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sandev.libraries.databinding.ActivityMainBinding
import com.sandev.searchingfield.SearchingFieldListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.searchingField.setHint("Ex: bla-bla-bla")
        initListeners()
    }

    private fun initListeners() {
        binding.searchingField.setListener(object : SearchingFieldListener {
            override fun onTextChanged(currentText: String, previousText: String) {
                binding.tvText.text = "$currentText // $previousText"
            }

            override fun onClosePressed() {
                binding.searchingField.visibility = View.GONE
            }

            override fun onClearPressed() {
                binding.tvText.text = "clear"
            }

        })
    }
}