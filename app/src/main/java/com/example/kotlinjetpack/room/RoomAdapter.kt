package com.example.kotlinjetpack.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinjetpack.R
import com.example.kotlinjetpack.databinding.RoomItemBinding

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/14 17:14:14
 * @Describe:
 */
class RoomAdapter(
    datas: ArrayList<Student>,
    viewModel: RoomViewModel
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    var mList: List<Student> = ArrayList()
    var mViewModel: RoomViewModel? = null

    init {
        mList = datas
        mViewModel = viewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        var binding: RoomItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.room_item,
            parent,
            false
        )
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bindView.student = mList.get(position)
        holder.bindView.viewModel = mViewModel
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class RoomViewHolder(var bindView: RoomItemBinding) : RecyclerView.ViewHolder(bindView.root) {

    }
}