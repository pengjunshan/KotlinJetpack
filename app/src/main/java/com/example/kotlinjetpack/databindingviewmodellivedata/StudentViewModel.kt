package com.example.kotlinjetpack.databindingviewmodellivedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/4/20 10:01:01
 * @Describe:
 */
class StudentViewModel : ViewModel() {

    var studentList: MutableLiveData<ArrayList<Student>>? = null

    init {
        studentList = MutableLiveData()
        studentList!!.value = ArrayList()
    }

    fun addStudentList() {
        val ss = ArrayList<Student>()
        ss.add(Student(12, "小明"))
        ss.add(Student(32, "小胖"))
        ss.add(Student(12, "小芳"))
        ss.add(Student(322, "小六"))
        studentList!!.value!!.addAll(ss)
        studentList!!.value = studentList!!.value
        Log.e("TAG", "6688=${studentList!!.value}")
    }

}