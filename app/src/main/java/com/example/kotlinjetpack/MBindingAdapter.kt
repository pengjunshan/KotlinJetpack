package com.example.kotlinjetpack

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinjetpack.databindingviewmodellivedata.Student
import com.example.kotlinjetpack.databindingviewmodellivedata.StudentAdapter
import com.example.kotlinjetpack.room.RoomAdapter
import com.example.kotlinjetpack.room.RoomViewModel
import java.util.*

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/4/20 10:44:44
 * @Describe:
 */
object MBindingAdapter {
    @BindingAdapter("bindData")
    @JvmStatic
    fun bindAdapter(rv: RecyclerView, datas: ArrayList<Student>?) {
        rv.adapter = StudentAdapter(datas)
        rv.layoutManager = LinearLayoutManager(rv.context)
        rv.addItemDecoration(DividerItemDecoration(rv.context, DividerItemDecoration.VERTICAL))
    }

    @BindingAdapter("binRoomdData","viewModel" )
    @JvmStatic
    fun bindRoomAdapter(rv: RecyclerView, datas: ArrayList<com.example.kotlinjetpack.room.Student>,viewModel:RoomViewModel) {
        rv.adapter = RoomAdapter(datas,viewModel)
        rv.layoutManager = LinearLayoutManager(rv.context)
        rv.addItemDecoration(DividerItemDecoration(rv.context,DividerItemDecoration.VERTICAL))
    }

}