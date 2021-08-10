package com.example.kotlinjetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinjetpack.R
import com.example.kotlinjetpack.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    var mList: ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databind =
            DataBindingUtil.setContentView<ActivityRoomBinding>(this, R.layout.activity_room)
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(RoomViewModel::class.java)
        databind.lifecycleOwner = this

        databind.viewModel = viewModel
        databind.binRoomdData = mList

        viewModel.getStudentList().observe(this, Observer {
            mList.clear()
            mList.addAll(it)
            if (databind.mRecyclerView.adapter != null) {
                databind.mRecyclerView.adapter!!.notifyDataSetChanged()
            }
        })

    }
}