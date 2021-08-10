package com.example.kotlinjetpack.databindingviewmodellivedata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinjetpack.R
import com.example.kotlinjetpack.databinding.StudentItemBinding
import java.util.*

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/4/20 10:38:38
 * @Describe:
 */
class StudentAdapter(datas: ArrayList<Student>?) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder?>() {
    private var mList: List<Student>? = ArrayList()

    init {
        mList = datas
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding: StudentItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.student_item,
            parent,
            false
        )
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.student = mList?.get(position) ?: null
    }

    override fun getItemCount(): Int {
        if (mList==null){
            return 0
        }
        return mList!!.size
    }

    class StudentViewHolder(val binding: StudentItemBinding) :
        RecyclerView.ViewHolder(binding.root)


}