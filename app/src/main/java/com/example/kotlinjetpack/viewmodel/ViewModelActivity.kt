package com.example.kotlinjetpack.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinjetpack.databinding.ActivityViewModelBinding

/**
 * @copyright：杭州柯林电气股份有限公司版权所有
 * @author: PengJunShan
 * @time：2021/4/1 9:46
 * @describe：ViewModel使用
 */
class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityViewModelBinding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var viewModel: MyViewModelv = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(MyViewModelv::class.java)
        binding.textView.text = viewModel.mNumber.toString()
        binding.button.setOnClickListener {
            ++viewModel.mNumber
            binding.textView.text = viewModel.mNumber.toString()
        }
    }

}