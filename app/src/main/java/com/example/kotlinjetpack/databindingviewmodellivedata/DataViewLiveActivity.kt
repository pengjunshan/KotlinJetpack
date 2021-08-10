package com.example.kotlinjetpack.databindingviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinjetpack.R
import com.example.kotlinjetpack.TooUtils
import com.example.kotlinjetpack.databinding.ActivityDataViewLiveBinding

class DataViewLiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDataViewLiveBinding>(
            this,
            R.layout.activity_data_view_live
        )
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(StudentViewModel::class.java)

        // 给xml赋上相应的值
        binding.data = viewModel
        binding.listData = viewModel.studentList!!.value

        viewModel.studentList!!.observe(this, Observer {
            if (binding.mRecyclerView.adapter != null) {
                binding.mRecyclerView.adapter!!.notifyDataSetChanged()
            }
        })
        binding.lifecycleOwner = this
    }

}