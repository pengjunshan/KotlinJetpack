package com.example.kotlinjetpack.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinjetpack.R
import com.example.kotlinjetpack.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLiveDataBinding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: LiveDataViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(LiveDataViewModel::class.java)

        viewModel.mNumber.observe(this, Observer {
            binding.textView3.text = it.toString() + ""
        })

        binding.button6.setOnClickListener { viewModel.addNumber() }
    }
}